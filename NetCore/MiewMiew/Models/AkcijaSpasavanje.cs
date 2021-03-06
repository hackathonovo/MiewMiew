﻿using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class AkcijaSpasavanje
    {
        public AkcijaSpasavanje()
        {
            Poruka = new HashSet<Poruka>();
            Sudionici = new HashSet<Sudionici>();
            ZonePretrage = new HashSet<ZonePretrage>();
        }

        public int Id { get; set; }
        public string Naziv { get; set; }
        public string Opis { get; set; }
        public DateTime? Vrijeme { get; set; }
        public byte? Potraga { get; set; }
        public int? FazaZivotnogCiklusa { get; set; }
        public string VoditeljId { get; set; }
        public int? VrstaSpasavanjaId { get; set; }
        public double? Longitude { get; set; }
        public double? Latitude { get; set; }
        public string NazivLokacije { get; set; }
        public double? Radius { get; set; }

        public virtual ICollection<Poruka> Poruka { get; set; }
        public virtual ICollection<Sudionici> Sudionici { get; set; }
        public virtual ICollection<ZonePretrage> ZonePretrage { get; set; }
        public virtual AspNetUsers Voditelj { get; set; }
        public virtual VrstaSpasavanja VrstaSpasavanja { get; set; }
    }
}
