using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class SocketConnection
    {
        public int Id { get; set; }
        public string SocketId { get; set; }
        public string UserId { get; set; }

        public virtual AspNetUsers User { get; set; }
    }
}
