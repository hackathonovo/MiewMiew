using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class Nedostupan
    {
        public int Id { get; set; }
        public DateTime? Od { get; set; }
        public DateTime? Do { get; set; }
        public string KorisnikId { get; set; }

        public virtual AspNetUsers Korisnik { get; set; }
    }
}
