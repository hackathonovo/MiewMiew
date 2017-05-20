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
            return  _context.AspNetUsers.SingleOrDefault(u => u.Id == id);
        }

        public AspNetUsers GetUserByName(string username)
        {
            return _context.AspNetUsers.SingleOrDefault(u => u.UserName == username);
        }

        public void AddUser(AspNetUsers user)
        {
          
            _context.Add(user);
            _context.SaveChanges();
            Commit();
        }

        private void Commit()
        {
            _context.SaveChanges();
        }
    }
}
