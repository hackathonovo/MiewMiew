using MiewMiew.Models;
using MiewMiew.RescueAction.Models;

namespace MiewMiew.Dto
{
	public class SudioniciDto
	{
		public bool? Prihvatio { get; set; }
		public RescueActionDto AkcijaSpasavanje { get; set; }
		public int AkcijaSpasavanjaId { get; set; }
	}
}