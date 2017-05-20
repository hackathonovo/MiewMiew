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

        public async Task<AspNetUsers> GetUserById(string id)
        {
            return await _context.AspNetUsers.SingleOrDefaultAsync(u => u.Id == id);
        }

        public async Task<AspNetUsers> GetUserByName(string username)
        {
            return await _context.AspNetUsers.SingleOrDefaultAsync(u => u.UserName == username);
        }

        public async Task<AspNetUsers> GetUserByEmail(string email)
        {
            return await _context.AspNetUsers.SingleOrDefaultAsync(u => u.Email == email);
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
