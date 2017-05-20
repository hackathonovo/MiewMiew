using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MiewMiew.Helpers;
using MiewMiew.Models;

namespace MiewMiew.Services.Interfaces
{
    public interface IWebSocketDatabaseManager
    {
        SocketConnection GetUserConnectionsByUserId(string userId);
        SocketConnection GetSocketConnectionBySocketId(string socketId);
        void SaveUserSocketId(string userId, string socketId);
        SocketAuthInfo HandleUserAuthentication(string socketId, string username, string password);
    }
}
