using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using MiewMiew.WebSocketManager;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace MiewMiew.Controllers
{
    [Route("api/[controller]")]
    public class MessagesController : Controller
    {
        private NotificationsMessageHandler _notificationsMessageHandler { get; set; }

        public MessagesController(NotificationsMessageHandler notificationsMessageHandler)
        {
            _notificationsMessageHandler = notificationsMessageHandler;
        }

        [HttpGet("sendMessage")]
        public async Task SendMessage([FromQueryAttribute]string message)
        {
            await _notificationsMessageHandler.SendMessageToAllAsync(message);
        }
    }
}
