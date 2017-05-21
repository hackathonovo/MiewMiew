using System;
using System.Collections.Generic;

namespace MiewMiew.Models
{
    public partial class AspNetUsers
    {
        public AspNetUsers()
        {
            AkcijaSpasavanje = new HashSet<AkcijaSpasavanje>();
            AspNetUserClaims = new HashSet<AspNetUserClaims>();
            AspNetUserLogins = new HashSet<AspNetUserLogins>();
            AspNetUserRoles = new HashSet<AspNetUserRoles>();
            Dostupan = new HashSet<Dostupan>();
            Nedostupan = new HashSet<Nedostupan>();
            PorukaPrimaKorisnik = new HashSet<Poruka>();
            PorukaSaljeKorisnik = new HashSet<Poruka>();
            Socket = new HashSet<Socket>();
            SocketConnection = new HashSet<SocketConnection>();
            Sudionici = new HashSet<Sudionici>();
            VjestineKorisnika = new HashSet<VjestineKorisnika>();
        }

        public string Id { get; set; }
        public int AccessFailedCount { get; set; }
        public string ConcurrencyStamp { get; set; }
        public string Email { get; set; }
        public bool EmailConfirmed { get; set; }
        public bool LockoutEnabled { get; set; }
        public DateTimeOffset? LockoutEnd { get; set; }
        public string NormalizedEmail { get; set; }
        public string NormalizedUserName { get; set; }
        public string PasswordHash { get; set; }
        public string PhoneNumber { get; set; }
        public bool PhoneNumberConfirmed { get; set; }
        public string SecurityStamp { get; set; }
        public bool TwoFactorEnabled { get; set; }
        public string UserName { get; set; }
        public string Salt { get; set; }
        public DateTime? Created { get; set; }
        public string Ime { get; set; }
        public string Prezime { get; set; }
        public int? Razina { get; set; }
        public double? Latitude { get; set; }
        public double? Longitude { get; set; }
        public string Sms { get; set; }

        public virtual ICollection<AkcijaSpasavanje> AkcijaSpasavanje { get; set; }
        public virtual ICollection<AspNetUserClaims> AspNetUserClaims { get; set; }
        public virtual ICollection<AspNetUserLogins> AspNetUserLogins { get; set; }
        public virtual ICollection<AspNetUserRoles> AspNetUserRoles { get; set; }
        public virtual ICollection<Dostupan> Dostupan { get; set; }
        public virtual ICollection<Nedostupan> Nedostupan { get; set; }
        public virtual ICollection<Poruka> PorukaPrimaKorisnik { get; set; }
        public virtual ICollection<Poruka> PorukaSaljeKorisnik { get; set; }
        public virtual ICollection<Socket> Socket { get; set; }
        public virtual ICollection<SocketConnection> SocketConnection { get; set; }
        public virtual ICollection<Sudionici> Sudionici { get; set; }
        public virtual ICollection<VjestineKorisnika> VjestineKorisnika { get; set; }
    }
}
