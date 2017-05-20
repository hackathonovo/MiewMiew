using System;
using System.ComponentModel.DataAnnotations;

namespace MiewMiew.Rescuer.Model
{
	public class AvailableDto
	{
		public int Id { get; set; }

		[Required]
		public int? Od { get; set; }

		[Required]
		public int? Do { get; set; }

		[Required]
		public string KorisnikId { get; set; }
	}
}
