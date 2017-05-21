using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices.ComTypes;
using System.Threading.Tasks;
using AutoMapper;
using Microsoft.EntityFrameworkCore;
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
			return _context.AkcijaSpasavanje.Include(a => a.Voditelj).Include(a => a.VrstaSpasavanja);
		}

		public IEnumerable<AkcijaSpasavanje> GetAllActionsActive()
		{
			return _context.AkcijaSpasavanje.Include(a => a.Voditelj).Include(a => a.VrstaSpasavanja).Where(a => a.VrstaSpasavanjaId != (int) RescueCycleTypeEnum.FinishedFailed ||
			                                            a.VrstaSpasavanjaId != (int) RescueCycleTypeEnum.FinishedSuccessfully);
		}

		public IEnumerable<AkcijaSpasavanje> GetAllActionsActiveForUser(string userId)
		{
			var actions = GetActionsByUserId(userId);
			return actions.Where(a => a.VrstaSpasavanjaId != (int) RescueCycleTypeEnum.FinishedFailed ||
									  a.VrstaSpasavanjaId != (int) RescueCycleTypeEnum.FinishedSuccessfully);
		}

		public AkcijaSpasavanje GetActionById(int id)
		{
			return _context.AkcijaSpasavanje.Include(a => a.Voditelj).Include(a => a.VrstaSpasavanja).SingleOrDefault(a => a.Id == id);
		}

		public IEnumerable<AkcijaSpasavanje> GetActionsByUserId(string userId)
		{
			return _context.AkcijaSpasavanje.Include(a => a.Voditelj)
				.Include(a => a.VrstaSpasavanja)
				.Include(a => a.Sudionici)
				.Where(a => a.VoditeljId == userId || a.Sudionici.Any(s => s.KorisnikId == userId && s.Prihvatio == true ));
		}

		public IEnumerable<Sudionici> GetMineRequests(string userdId)
		{
			return _context.Sudionici.Include(s => s.AkcijaSpasavanja).Where(s => s.KorisnikId == userdId && s.Prihvatio != null && !(bool)s.Prihvatio);
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

		public AkcijaSpasavanje EditAction(RescueActionDto dto, int id)
		{
			var action = GetActionById(id);
			Mapper.Map<RescueActionDto, AkcijaSpasavanje>(dto, action);
			action.Vrijeme = DateTime.Now;
			Commit();
			return action;
		}

		public Sudionici AcceptMyInvitation(string userId, int actionId)
		{
			var invitation = _context.Sudionici.SingleOrDefault(s => s.KorisnikId == userId && s.AkcijaSpasavanjaId == actionId);
			if (invitation != null)
			{
				invitation.Prihvatio = true;
				Commit();
			}
			return invitation;
		}

		public void UpdateActionStatus(int actionId, RescueTypeEnum rescueTypeEnum)
		{
			var action = GetActionById(actionId);
			action.FazaZivotnogCiklusa = (int)rescueTypeEnum;
			Commit();
		}


		private void Commit()
		{
			_context.SaveChanges();
		}
	}
}

