using System.Threading.Tasks;
using MiewMiew.Models;

namespace MiewMiew.Repository
{
	public interface IUserRepository
	{
		AspNetUsers GetUserById(string id);
		AspNetUsers GetUserByName(string username);
		void AddUser(AspNetUsers user);
	}
}
