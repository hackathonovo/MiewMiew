using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class Poruka
    {
        public int Id { get; set; }
        public string Poruka1 { get; set; }
        public int? AkcijaId { get; set; }
        public string SaljeKorisnikId { get; set; }
        public DateTime? Vrijeme { get; set; }
        public string PrimaKorisnikId { get; set; }
        public byte? Procitano { get; set; }

        public virtual AkcijaSpasavanje Akcija { get; set; }
        public virtual AspNetUsers PrimaKorisnik { get; set; }
        public virtual AspNetUsers SaljeKorisnik { get; set; }
    }
}
