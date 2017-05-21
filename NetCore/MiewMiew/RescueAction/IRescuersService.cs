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
		IEnumerable<AkcijaSpasavanje> GetActionsByUserId(string userId);
		IEnumerable<AkcijaSpasavanje> GetAllActionsActiveForUser(string userId);
	}
}