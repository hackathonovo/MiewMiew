using System.Collections.Generic;
using System.Threading.Tasks;
using MiewMiew.Models;

namespace MiewMiew.RescueAction
{
	public interface IRescuersService
	{
		IEnumerable<AkcijaSpasavanje> GetAllActions();
		IEnumerable<AkcijaSpasavanje> GetAllActionsActive();
		AkcijaSpasavanje GetActionById(int id);
		AkcijaSpasavanje AddAction(AkcijaSpasavanje action, string identityName);
	}
}