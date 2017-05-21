using System.Collections.Specialized;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using AutoMapper;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using MiewMiew.Dto;
using MiewMiew.Helpers;
using MiewMiew.Models;
using MiewMiew.Repository;
using MiewMiew.RescueAction;
using MiewMiew.Rescuer.Model;
using MiewMiew.Services.Interfaces;
using Newtonsoft.Json;
using Shared.Dto.RequestDto;
using Shared.Dto.ResponseDto;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace MiewMiew.Controllers
{
	[Route("api/[controller]")]
	public class UsersController : Controller
	{
		private readonly IMembershipService _membershipService;
		private readonly IUserRepository _userRepository;
		private readonly IRescuersService _rescuersService;

		public UsersController(IMembershipService membershipService, IUserRepository userRepository, IRescuersService rescuersService)
		{
			_membershipService = membershipService;
			_userRepository = userRepository;
			_rescuersService = rescuersService;
		}


		[HttpPost("login")]
		[Produces(typeof(UserToken))]
		public IActionResult Login([FromBody] LoginDto loginDto)
		{
			if (loginDto?.Username == null || loginDto.Password == null)
				return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.FormatError));
			var result = _membershipService.Login(loginDto.Username, loginDto.Password);
			if (result.Authenticated != true)
				return BadRequest(
					ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError, "Wrong username or password"));
			return Ok(result);
		}


		[HttpPost("register")]
		[Produces(typeof(MessageDto))]
		public IActionResult Register([FromBody] RegisterDto registerDto)
		{
			if (registerDto == null)
			{
				return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.FormatError));
			}
			var result = _membershipService.Register(registerDto);
			if (result.Status != true)
				return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError, result.Message));
			return Ok(result);
		}


		[HttpPost("addAvailability")]
		[Produces(typeof(UserDto))]
		public IActionResult AddAvailabilityToUser([FromBody] AvailableDto dto)
		{
			if (ModelState.IsValid)
			{
				_userRepository.AddAvailableTimeForUser(Mapper.Map<AvailableDto, Dostupan>(dto));
				var us = _userRepository.GetUserById(dto.KorisnikId);
				return Ok(Mapper.Map<AspNetUsers, UserDto>(us));
			}
			return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError,
				"Vrijeme od,Vrijeme do i korisnik su obavezna polja"));
		}

		[HttpPost("addUnavailability")]
		[Produces(typeof(UserDto))]
		public IActionResult AddUnavailabilityToUser([FromBody] UnavailableDto dto)
		{
			if (ModelState.IsValid)
			{
				_userRepository.AddUnavailableTimeForUser(Mapper.Map<UnavailableDto, Nedostupan>(dto));
				return Ok(Mapper.Map<AspNetUsers, UserDto>(_userRepository.GetUserById(dto.KorisnikId)));
			}
			return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError,
				"Vrijeme od,Vrijeme do i korisnik su obavezna polja"));
		}

		[HttpPost("sendSms/{userId}/{actionId}")]
		[Produces(typeof(MessageDto))]
		public async Task<IActionResult> SendSms(string userId, int actionId)
		{
			var user = _userRepository.GetUserById(userId);
			var action = _rescuersService.GetActionById(actionId);
			if (user.Sms != null)
			{
				var content = new SmsDto
				{
					message = "HGSS: Please respond if you are available for action: "+ action.Naziv + " in " + action.NazivLokacije,
					phone = user.Sms
				};
				var httpContent = new StringContent(JsonConvert.SerializeObject(content), Encoding.UTF8, "application/json");

				var result = await new HttpClient().PostAsync("https://textbelt.com/text", httpContent);
				return Ok(result);
			}

			return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError, "User has no sms"));
		}


		[Authorize("Bearer")]
		[HttpGet("refreshToken")]
		[Produces(typeof(UserToken))]
		public IActionResult RefreshToken()
		{
			return Ok(_membershipService.RefreshTokens(User.Identity.Name));
		}
	}
}