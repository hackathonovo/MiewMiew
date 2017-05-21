using System;
using System.Net.WebSockets;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MiewMiew.Dto;
using MiewMiew.Helpers;
using MiewMiew.Services.Interfaces;
using Shared.Dto.RequestDto;

namespace MiewMiew.WebSocketManager
{
	public class NotificationsMessageHandler : WebSocketHandler
	{
		private readonly IWebSocketDatabaseManager _webSocketDatabaseManager;

		public NotificationsMessageHandler(WebSocketConnectionManager webSocketConnectionManager, IWebSocketDatabaseManager webSocketDatabaseManager) : base(webSocketConnectionManager)
		{
			_webSocketDatabaseManager = webSocketDatabaseManager;
		}

		public override async Task OnConnected(WebSocket socket)
		{
			await base.OnConnected(socket);
			var socketId = WebSocketConnectionManager.GetId(socket);
	 //       await SendMessageToAllAsync($"{socketId} is now connected");
		}

		public override async Task ReceiveAsync(WebSocket socket, WebSocketReceiveResult result, byte[] buffer)
		{
			var m = Encoding.UTF8.GetString(buffer, 0, result.Count);
			if (!Helper.IsJson(m))
			{
				await SendMessageAsync(socket, GenerateMessageForInvalidJson());
				return;
			}
	 /*       var loginDto = Helper.MapJsonStringToObject<LoginDto>(m);
			var socketAuthInfo = _webSocketDatabaseManager.HandleUserAuthentication(WebSocketConnectionManager.GetId(socket),
				loginDto.Username, loginDto.Password);
			if (socketAuthInfo == null)
			{
				await SendMessageAsync(socket, GenerateMessageForFailedAuth() );
				return;
			}
			if (socketAuthInfo.IsNewConnection)
			{
				await SendMessageAsync(socket, GenerateSuccessLoginMessage());
				return;
			}
			*/

			await HandleMessageFromType(m);

		}

		private async Task HandleMessageFromType(string m)
		{
				var messageDto = Helper.MapJsonStringToObject<MessageDto>(m);
				await SendMessageToAllAsync(m.Replace(@"\", ""));
		}

		private SocketMessageDto GenerateMessageForFailedAuth()
		{
			return new SocketMessageDto
			{
				StatusCode = 404,
				Message = "Not authenticated"
			};
		}

		private SocketMessageDto GenerateMessageForInvalidJson()
		{
			return new SocketMessageDto
			{
				StatusCode = 400,
				Message = "Invalid Json"
			};
		}

		private SocketMessageDto GenerateSuccessfullMessage(string msg)
		{
			return new SocketMessageDto
			{
				StatusCode = 200,
				Message = msg
			};
		}

		private SocketMessageDto GenerateSuccessLoginMessage()
		{
			return new SocketMessageDto
			{
				StatusCode = 200,
				Message = "Spojil si se"
			};
		}



	}
}
