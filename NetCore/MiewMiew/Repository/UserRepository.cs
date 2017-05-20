using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using MiewMiew.Models;

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
			return  _context.AspNetUsers.Include(u => u.Dostupan).Include(u => u.Nedostupan).Include(u => u.AkcijaSpasavanje).SingleOrDefault(u => u.Id == id);
		}

		public AspNetUsers GetUserByName(string username)
		{
			return _context.AspNetUsers.Include(u => u.Dostupan).Include(u => u.Nedostupan).SingleOrDefault(u => u.UserName == username);
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

		private void Commit()
		{
			_context.SaveChanges();
		}
	}
}
