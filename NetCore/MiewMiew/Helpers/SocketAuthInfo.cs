using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MiewMiew.Helpers
{
    public class SocketAuthInfo
    {
        public string UserId { get; set; }
        public bool IsNewConnection { get; set; }

        public SocketAuthInfo(string userId, bool isNewConnection)
        {
            UserId = userId;
            IsNewConnection = isNewConnection;
        }

        public SocketAuthInfo(string userId)
        {
            IsNewConnection = false;
            UserId = userId;
        }
    }
}
