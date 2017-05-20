using System;
using System.Net.WebSockets;
using System.Threading;
using System.Threading.Tasks;
using AutoMapper;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Cors.Infrastructure;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.IdentityModel.Tokens;
using MiewMiew.Middleware;
using MiewMiew.Models;
using MiewMiew.Repository;
using MiewMiew.RescueAction;
using MiewMiew.RescueAction.Models;
using MiewMiew.Services;
using MiewMiew.Services.Interfaces;
using MiewMiew.WebSocketManager;
using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;
using Shared.Dto;
using SL.Core.Authentication;
using SL.Core.Service;
using SL.Core.Service.Interfaces;

namespace MiewMiew
{
	public class Startup
	{
		private RsaSecurityKey key;
		private TokenAuthOptions tokenOptions;
		public static TokenValidationParameters tokenValidationParametars;

		public Startup(IHostingEnvironment env)
		{
			var builder = new ConfigurationBuilder()
				.SetBasePath(env.ContentRootPath)
				.AddJsonFile("appsettings.json", false, true)
				.AddJsonFile($"appsettings.{env.EnvironmentName}.json", true)
				.AddEnvironmentVariables();
			Configuration = builder.Build();
		}

		public IConfigurationRoot Configuration { get; }

		// This method gets called by the runtime. Use this method to add services to the container.
		public void ConfigureServices(IServiceCollection services)
		{
			#region Token Config

			// *** CHANGE THIS FOR PRODUCTION USE ***
			// Here, we're generating a random key to sign tokens - obviously this means
			// that each time the app is started the key will change, and multiple servers 
			// all have different keys. This should be changed to load a key from a file 
			// securely delivered to your application, controlled by configuration.
			//
			// See the RSAKeyUtils.GetKeyParameters method for an examle of loading from
			// a JSON file.
			var keyParams = RSAKeyUtils.GetRandomKey(); //TODO secure storage

			// Create the key, and a set of token options to record signing credentials 
			// using that key, along with the other parameters we will need in the 
			// token controlller.
			key = new RsaSecurityKey(keyParams);
			tokenOptions = new TokenAuthOptions
			{
				Audience = Configuration["TokenAudience"],
				Issuer = Configuration["TokenIssuser"],
				SigningCredentials = new SigningCredentials(key, SecurityAlgorithms.RsaSha256Signature)
			};

			// Save the token options into an instance so they're accessible to the 
			// controller.
			services.AddSingleton(tokenOptions);

			// Enable the use of an [Authorize("Bearer")] attribute on methods and classes to protect.
			services.AddAuthorization(auth =>
			{
				auth.AddPolicy("Bearer", new AuthorizationPolicyBuilder()
					//     .AddAuthenticationSchemes(JwtBearerDefaults.AuthenticationScheme‌​)
					.RequireAuthenticatedUser().Build());
			});

			//   services.Configure<Settings>(Configuration.GetSection("App"));

			#endregion

			#region Repositories

			services.AddScoped<IUserRepository, UserRepository>();

			#endregion

			services.AddScoped<IMembershipService, MembershipService>();
			services.AddScoped<IEncryptionService, EncryptionService>();
			services.AddScoped<IWebSocketDatabaseManager, WebSocketDatabaseManager>();
			services.AddScoped<IRescuersService, RescuersService>();


			services.AddSwaggerGen();

			#region corsBuilder

			var corsBuilder = new CorsPolicyBuilder();
			corsBuilder.AllowAnyHeader();
			corsBuilder.AllowAnyMethod();
			corsBuilder.AllowAnyOrigin();
			corsBuilder.AllowCredentials();
			services.AddCors(options => { options.AddPolicy("AllowAll", corsBuilder.Build()); });

			#endregion

			// Add framework services.
			services.AddMvc()
				.AddViewLocalization()
				.AddDataAnnotationsLocalization()
				.AddJsonOptions(opt =>
				{
					opt.SerializerSettings.ContractResolver = new CamelCasePropertyNamesContractResolver();
					opt.SerializerSettings.PreserveReferencesHandling = PreserveReferencesHandling.None;
				});

			   services.AddWebSocketManager();

			services.AddDbContext<HackatonIn2Context>(
				options => options.UseSqlServer(Configuration.GetConnectionString("DefaultConnection")));
		}

		// This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
		public void Configure(IApplicationBuilder app, IHostingEnvironment env, ILoggerFactory loggerFactory, IServiceProvider serviceProvider)
		{
			#region Tokens

			tokenValidationParametars = new TokenValidationParameters
			{
				IssuerSigningKey = key,
				ValidAudience = tokenOptions.Audience,
				ValidIssuer = tokenOptions.Issuer,
				ValidateLifetime = true,
				ClockSkew = TimeSpan.FromMinutes(0)
			};


			var options = new JwtBearerOptions
			{
				TokenValidationParameters = tokenValidationParametars
			};

			app.UseJwtBearerAuthentication(options);

			#endregion

			loggerFactory.AddConsole(Configuration.GetSection("Logging"));
			loggerFactory.AddDebug();

			app.UseStaticFiles();

			app.UseDeveloperExceptionPage();

			app.UseCors("AllowAll");


			// Enable middleware to serve generated Swagger as a JSON endpoint
			app.UseSwagger();

			// Enable middleware to serve swagger-ui assets (HTML, JS, CSS etc.)
			app.UseSwaggerUi();


			Mapper.Initialize(config =>
			{
				config.CreateMap<UserInfoDto, AspNetUsers>().ReverseMap();
				config.CreateMap<AkcijaSpasavanje, RescueActionDto>()
					.ForMember(a => a.RescueLiveCycle, a => a.MapFrom(am => ((RescueCycleTypeEnum) am.FazaZivotnogCiklusa).ToString()))
					.ForMember(a => a.RescueType, a => a.MapFrom(am => am.VrstaSpasavanja.Vrsta));

				config.CreateMap<RescueActionDto, AkcijaSpasavanje>();
			});

			var webSocketOptions = new WebSocketOptions()
			{
				KeepAliveInterval = TimeSpan.FromSeconds(5),
				ReceiveBufferSize = 4 * 1024
			};
			app.UseWebSockets(webSocketOptions);

			app.UseMiddleware<ErrorHandlingMiddleware>();

			app.UseMvc();
		   app.MapWebSocketManager("/notifications", serviceProvider.GetService<NotificationsMessageHandler>());
		}

		private async Task Echo(HttpContext context, WebSocket webSocket)
		{
			var buffer = new byte[1024 * 4];
			var result = await webSocket.ReceiveAsync(new ArraySegment<byte>(buffer), CancellationToken.None);
			while (!result.CloseStatus.HasValue)
			{
				await webSocket.SendAsync(new ArraySegment<byte>(buffer, 0, result.Count), result.MessageType,
					result.EndOfMessage, CancellationToken.None);

				result = await webSocket.ReceiveAsync(new ArraySegment<byte>(buffer), CancellationToken.None);
			}
			await webSocket.CloseAsync(result.CloseStatus.Value, result.CloseStatusDescription, CancellationToken.None);
		}
	}
}