using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class KompetencijeKorisnika
    {
        public int Id { get; set; }
        public string Korisnik { get; set; }
        public int? Kompetencija { get; set; }
    }
}
