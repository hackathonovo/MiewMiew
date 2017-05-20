using Shared.Dto.RequestDto;
using Shared.Dto.ResponseDto;

namespace SL.Core.Service.Interfaces
{
    public interface IMembershipService
    {
        UserToken Login(string username, string password);
        MessageDto Register(RegisterDto registerDto);
        UserToken RefreshTokens(string userName);
        string GetAuthUserFromToken(string token);
    }
}
