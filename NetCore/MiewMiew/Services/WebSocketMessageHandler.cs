using System;
using MiewMiew.Services.Interfaces;
using MiewMiew.WebSocketManager;
using Shared.Dto.RequestDto;

namespace MiewMiew.Services
{
	public class WebSocketMessageHandler
	{
		private readonly IWebSocketDatabaseManager _webSocketDatabaseManager;

		public WebSocketMessageHandler(IWebSocketDatabaseManager webSocketDatabaseManager)
		{
			_webSocketDatabaseManager = webSocketDatabaseManager;
		}
	}
}
