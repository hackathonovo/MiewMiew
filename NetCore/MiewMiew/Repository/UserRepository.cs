using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using MiewMiew.Models;
using Shared.Dto;

namespace MiewMiew.Repository
{
	public class UserRepository : IUserRepository
	{
		private readonly HackatonIn2Context _context;


		public UserRepository(HackatonIn2Context context)
		{
			_context = context;
		}

		public AspNetUsers GetUserById(string id)
		{
			return  _context.AspNetUsers
				.Include(u => u.Dostupan)
				.Include(u => u.Nedostupan)
				.Include(u => u.AkcijaSpasavanje)
				.Include(u => u.VjestineKorisnika)
				.ThenInclude(uu => uu.Specijalnost)
				.SingleOrDefault(u => u.Id == id);
		}

		public bool IsUserUnavailable(string userId, DateTime dateTime)
		{
			var user = GetUserById(userId);
			return user.Nedostupan.Any(u => u.Od >= dateTime && u.Do <= dateTime);
		}

		public IEnumerable<AspNetUsers> GetAll()
		{
			return _context.AspNetUsers.Include(u => u.Dostupan).Include(u => u.Nedostupan).Include(u => u.VjestineKorisnika);
		}

		public AspNetUsers GetUserByName(string username)
		{
			return _context.AspNetUsers.Include(u => u.Dostupan).Include(u => u.Nedostupan).Include(u => u.VjestineKorisnika).SingleOrDefault(u => u.UserName == username);
		}

		public void AddUser(AspNetUsers user)
		{
		  
			_context.Add(user);
			_context.SaveChanges();
			Commit();
		}

		public void AddAvailableTimeForUser(Dostupan available)
		{
			_context.Dostupan.Add(available);
			Commit();
		}

		public void AddUnavailableTimeForUser(Nedostupan unavailable)
		{
			_context.Nedostupan.Add(unavailable);
			Commit();
		}

		public void AddSpecijalnostToUser(int specijalnostId, string userId)
		{
			var newSpecijalnost = new VjestineKorisnika
			{
				SpecijalnostId = specijalnostId,
				KorisnikId = userId
			};
			_context.VjestineKorisnika.Add(newSpecijalnost);
			Commit();
		}

		private void Commit()
		{
			_context.SaveChanges();
		}
	}
}
