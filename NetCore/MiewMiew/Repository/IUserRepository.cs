using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using MiewMiew.Models;

namespace MiewMiew.Repository
{
	public interface IUserRepository
	{
		AspNetUsers GetUserById(string id);
		AspNetUsers GetUserByName(string username);
		void AddUser(AspNetUsers user);
		void AddAvailableTimeForUser(Dostupan available);
		void AddUnavailableTimeForUser(Nedostupan unavailable);
		void AddSpecijalnostToUser(int specijalnostId, string userId);
		IEnumerable<AspNetUsers> GetAll();
		bool IsUserUnavailable(string userId, DateTime dateTime);
	}
}
