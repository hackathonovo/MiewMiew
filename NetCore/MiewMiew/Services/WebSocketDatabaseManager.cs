using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Net.Sockets;
using System.Threading.Tasks;
using Microsoft.IdentityModel.Tokens;
using MiewMiew.Helpers;
using MiewMiew.Models;
using MiewMiew.Services.Interfaces;
using SL.Core.Service.Interfaces;

namespace MiewMiew.Services
{

    public class WebSocketDatabaseManager : IWebSocketDatabaseManager
    {
        private readonly HackatonIn2Context _context;
        private readonly IMembershipService _membershipService;

        public WebSocketDatabaseManager(HackatonIn2Context context, IMembershipService membershipService)
        {
            _context = context;
            _membershipService = membershipService;
        }

        public SocketConnection GetUserConnectionsByUserId(string userId)
        {
            return _context.SocketConnection.FirstOrDefault(sc => sc.UserId == userId);
        }

        public SocketConnection GetSocketConnectionBySocketId(string socketId)
        {
            return _context.SocketConnection.FirstOrDefault(sc => sc.SocketId == socketId);
        }

        public void DeleteSocketConnectionForUser(string userId)
        {
            var socketConn = GetUserConnectionsByUserId(userId);
            if (socketConn != null)
            {
                _context.SocketConnection.Remove(socketConn);
                Commit();
            }
        }

        public void SaveUserSocketId(string userId, string socketId)
        {
            var socketCon = new SocketConnection
            {
                SocketId = socketId,
                UserId = userId
            };
            _context.Add(socketCon);
            Commit();
        }

        public SocketAuthInfo HandleUserAuthentication(string socketId, string username, string password)
        {
            var socConnection = GetSocketConnectionBySocketId(socketId);
            if (socConnection != null)
            {
                return new SocketAuthInfo(socConnection.UserId);
            }
            if (username != null && password != null)
            {
                return ValidateUserAndSaveConnection(username, password, socketId);
            }
            return null;
        }

        private SocketAuthInfo ValidateUserAndSaveConnection(string username, string password, string socketId)
        {
            var loginDto = _membershipService.Login(username, password);
            if (loginDto != null)
            {
                DeleteSocketConnectionForUser(loginDto.UserInfo.Id);
                SaveUserSocketId(loginDto.UserInfo.Id, socketId);
                return new SocketAuthInfo(loginDto.UserInfo.Id, true);
            }
            return null;
        }


        private void Commit()
        {
            _context.SaveChanges();
        }
    }
}
