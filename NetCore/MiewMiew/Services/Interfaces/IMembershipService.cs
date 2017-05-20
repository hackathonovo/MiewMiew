using Shared.Dto.RequestDto;
using Shared.Dto.ResponseDto;

namespace MiewMiew.Services.Interfaces
{
    public interface IMembershipService
    {
        UserToken Login(string username, string password);
        MessageDto Register(RegisterDto registerDto);
        UserToken RefreshTokens(string userName);
        string GetAuthUserFromToken(string token);
    }
}
