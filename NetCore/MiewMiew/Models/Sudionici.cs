using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class Sudionici
    {
        public string KorisnikId { get; set; }
        public int AkcijaSpasavanjaId { get; set; }
        public decimal? Latitude { get; set; }
        public decimal? Longitude { get; set; }

        public virtual AkcijaSpasavanje AkcijaSpasavanja { get; set; }
        public virtual AspNetUsers Korisnik { get; set; }
    }
}
