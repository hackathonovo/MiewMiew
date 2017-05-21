using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class Sudionici
    {
        public string KorisnikId { get; set; }
        public int AkcijaSpasavanjaId { get; set; }
        public double? Latitude { get; set; }
        public double? Longitude { get; set; }
        public bool? Prihvatio { get; set; }

        public virtual AkcijaSpasavanje AkcijaSpasavanja { get; set; }
        public virtual AspNetUsers Korisnik { get; set; }
    }
}
