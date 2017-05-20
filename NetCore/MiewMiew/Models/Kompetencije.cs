using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class Kompetencije
    {
        public int Id { get; set; }
        public int VrstaSpasavanja { get; set; }
        public int Specijalnosti { get; set; }

        public virtual VrstaSpasavanja VrstaSpasavanjaNavigation { get; set; }
    }
}
