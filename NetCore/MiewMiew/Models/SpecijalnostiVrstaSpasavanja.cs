using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class SpecijalnostiVrstaSpasavanja
    {
        public int Id { get; set; }
        public int? SpecijalnostiId { get; set; }
        public int? VrstaSpasavanjaId { get; set; }

        public virtual Specijalnosti Specijalnosti { get; set; }
        public virtual VrstaSpasavanja VrstaSpasavanja { get; set; }
    }
}
