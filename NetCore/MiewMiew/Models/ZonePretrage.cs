using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class ZonePretrage
    {
        public int Id { get; set; }
        public string Naziv { get; set; }
        public double? Latitude { get; set; }
        public double? Longitude { get; set; }
        public int? AkcijaSpasavanjaId { get; set; }

        public virtual AkcijaSpasavanje AkcijaSpasavanja { get; set; }
    }
}
