using System;

namespace MiewMiew.Rescuer.Model
{
	public class UnavailableDto
	{
		public int Id { get; set; }
		public DateTime? Od { get; set; }
		public DateTime? Do { get; set; }
		public string KorisnikId { get; set; }
	}
}
