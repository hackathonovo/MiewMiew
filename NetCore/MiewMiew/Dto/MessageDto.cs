namespace Shared.Dto.ResponseDto
{
    public class MessageDto
    {
        public bool Status { get; set; }
        public string Message { get; set; }

        public MessageDto(bool status, string message)
        {
            this.Status = status;
            this.Message = message;
        }
        
    }

}
