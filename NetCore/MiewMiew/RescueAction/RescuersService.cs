using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices.ComTypes;
using System.Threading.Tasks;
using MiewMiew.Models;
using MiewMiew.Repository;
using MiewMiew.RescueAction.Models;

namespace MiewMiew.RescueAction
{
	public class RescuersService : IRescuersService
	{
		private readonly HackatonIn2Context _context;
		private readonly IUserRepository _userRepository;

		public RescuersService(HackatonIn2Context context, IUserRepository userRepository)
		{
			_context = context;
			_userRepository = userRepository;
		}

		public IEnumerable<AkcijaSpasavanje> GetAllActions()
		{
			return _context.AkcijaSpasavanje;
		}

		public IEnumerable<AkcijaSpasavanje> GetAllActionsActive()
		{
			return _context.AkcijaSpasavanje.Where(a => a.VrstaSpasavanjaId != (int) RescueCycleTypeEnum.FinishedFailed ||
			                                            a.VrstaSpasavanjaId != (int) RescueCycleTypeEnum.FinishedSuccessfully);
		}

		public AkcijaSpasavanje GetActionById(int id)
		{
			return _context.AkcijaSpasavanje.SingleOrDefault(a => a.Id == id);
		}

		public AkcijaSpasavanje AddAction(AkcijaSpasavanje action, string identityName)
		{
			action.Vrijeme = DateTime.Now;
			action.FazaZivotnogCiklusa = (int)RescueCycleTypeEnum.Created;
			action.VoditeljId = _userRepository.GetUserByName(identityName).Id;
			_context.Add(action);
			Commit();
			return action;
		}


		private void Commit()
		{
			_context.SaveChanges();
		}
	}
}

