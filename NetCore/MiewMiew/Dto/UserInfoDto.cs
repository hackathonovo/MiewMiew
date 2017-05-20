namespace Shared.Dto
{
    public class UserInfoDto
    {
        public string Id { get; set; }
        public string Username { get; set; }

        public UserInfoDto(string username,string id)
        {
            Username = username;
            Id = id;
        }
    }
}
