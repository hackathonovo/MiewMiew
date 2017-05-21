using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Threading.Tasks;
using MiewMiew.Models;
using MiewMiew.Rescuer.Model;

namespace MiewMiew.Dto
{
	public class UserDto
	{
		public string Id { get; set; }
		public string Email { get; set; }
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

		public IEnumerable<AvailableDto> Dostupan { get; set; }
		public IEnumerable<VjestineKorisnika> Vjestine { get; set; }
		public Collection<UnavailableDto> Nedostupan{ get; set; }
	}
}
