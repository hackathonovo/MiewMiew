using System.Collections.Generic;

namespace MiewMiew.Dto
{
	public class RegisterDto
	{
		public string Username { get; set; }

		public string Password { get; set; }

		public string Email { get; set; }

		public string Ime { get; set; }

		public string Prezime { get; set; }

		public int Razina { get; set; }

		public IEnumerable<int> VjestineKorisnikaId { get; set; }
	}
}
