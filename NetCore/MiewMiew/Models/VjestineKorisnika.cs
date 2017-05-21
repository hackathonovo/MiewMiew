using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class VjestineKorisnika
    {
        public int Id { get; set; }
        public string KorisnikId { get; set; }
        public int? SpecijalnostId { get; set; }

        public virtual AspNetUsers Korisnik { get; set; }
        public virtual Specijalnosti Specijalnost { get; set; }
    }
}
