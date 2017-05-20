using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class Dostupan
    {
        public int Id { get; set; }
        public int? Od { get; set; }
        public int? Do { get; set; }
        public int? Danutjednu { get; set; }
        public string KorisnikId { get; set; }

        public virtual AspNetUsers Korisnik { get; set; }
    }
}
