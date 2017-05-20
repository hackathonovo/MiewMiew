using System.Threading.Tasks;
using MiewMiew.Models;

namespace MiewMiew.Repository
{
    public interface IUserRepository
    {
        Task<AspNetUsers> GetUserById(string id);
        Task<AspNetUsers> GetUserByName(string username);
        Task<AspNetUsers> GetUserByEmail(string email);
        void AddUser(AspNetUsers user);
    }
}
