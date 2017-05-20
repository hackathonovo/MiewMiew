using System;
using System.ComponentModel.DataAnnotations;

namespace MiewMiew.RescueAction.Models
{
	public class RescueActionDto
	{
		public int Id { get; set; }
		[Required]
		public string Naziv { get; set; }
		[Required]
		public string Opis { get; set; }
		public DateTime? Vrijeme { get; set; }
		[Required]
		public byte? Potraga { get; set; }
		public int? FazaZivotnogCiklusa { get; set; }
		public string VoditeljId { get; set; }
		public int? VrstaSpasavanjaId { get; set; }
		public decimal? Longitude { get; set; }
		public decimal? Latitude { get; set; }
		public string RescueLiveCycle { get; set; }
		public string RescueType { get; set; }
	}
}
