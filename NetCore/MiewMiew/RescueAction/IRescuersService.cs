using System.Collections.Generic;
using System.Threading.Tasks;
using MiewMiew.Models;
using MiewMiew.RescueAction.Models;

namespace MiewMiew.RescueAction
{
	public interface IRescuersService
	{
		IEnumerable<AkcijaSpasavanje> GetAllActions();
		IEnumerable<AkcijaSpasavanje> GetAllActionsActive();
		AkcijaSpasavanje GetActionById(int id);
		AkcijaSpasavanje AddAction(AkcijaSpasavanje action, string identityName);
		AkcijaSpasavanje EditAction(RescueActionDto dto, int id);
	}
}