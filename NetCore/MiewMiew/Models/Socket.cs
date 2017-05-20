using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class Socket
    {
        public int Id { get; set; }
        public string Message { get; set; }
        public string UserId { get; set; }

        public virtual AspNetUsers User { get; set; }
    }
}
