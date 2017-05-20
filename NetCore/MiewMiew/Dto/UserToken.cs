namespace Shared.Dto.ResponseDto
{
    public class UserToken
    {
        public bool Authenticated { get; set; }
        public string Token { get; set; }
        public double TokenExpires { get; set; }
        public UserInfoDto UserInfo { get; set; }
        public string Message { get; set; }

        public UserToken()
        {
            
        }

        public UserToken(string message)
        {
            Authenticated = false;
            Message = message;
        }

        public UserToken(bool authenticated,string token,double tokenExpires,UserInfoDto userInfoDto)
        {
            Authenticated = authenticated;
            Token = token;
            TokenExpires = tokenExpires;
            UserInfo = userInfoDto;
        }
    }
}
