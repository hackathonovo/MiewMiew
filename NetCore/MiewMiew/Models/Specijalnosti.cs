using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class Specijalnosti
    {
        public Specijalnosti()
        {
            SpecijalnostiVrstaSpasavanja = new HashSet<SpecijalnostiVrstaSpasavanja>();
            VjestineKorisnika = new HashSet<VjestineKorisnika>();
        }

        public int Id { get; set; }
        public string Naziv { get; set; }

        public virtual ICollection<SpecijalnostiVrstaSpasavanja> SpecijalnostiVrstaSpasavanja { get; set; }
        public virtual ICollection<VjestineKorisnika> VjestineKorisnika { get; set; }
    }
}
