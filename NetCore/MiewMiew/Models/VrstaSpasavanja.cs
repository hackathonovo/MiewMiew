using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class VrstaSpasavanja
    {
        public VrstaSpasavanja()
        {
            AkcijaSpasavanje = new HashSet<AkcijaSpasavanje>();
            SpecijalnostiVrstaSpasavanja = new HashSet<SpecijalnostiVrstaSpasavanja>();
        }

        public int Id { get; set; }
        public string Vrsta { get; set; }

        public virtual ICollection<AkcijaSpasavanje> AkcijaSpasavanje { get; set; }
        public virtual ICollection<SpecijalnostiVrstaSpasavanja> SpecijalnostiVrstaSpasavanja { get; set; }
    }
}
