using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MiewMiew.Dto
{
    public class ErrorMessageDto
    {
        public string Status { get; set; }
        public string Title { get; set; }
        public string Message { get; set; }


        public ErrorMessageDto(string title, string message)
        {
            Status = "Failure";
            Title = title;
            Message = message;
        }

        public ErrorMessageDto(ErrorType errorType, string message, ErrorStatusType status = ErrorStatusType.Failure)
        {
            Status = GetStatusFromErrorStatusType(status);
            Title = GetTitleFromErrorType(errorType);
            Message = message;
        }

        private string GetTitleFromErrorType(ErrorType errorType)
        {
            switch (errorType)
            {
                    case ErrorType.FormatError:
                        return "Bad request format";
                    case ErrorType.NotExist:
                        return "Requested item does not exist";
                    case ErrorType.Unauthorized:
                        return "Unauthorized request";
                    case ErrorType.ValidationError:
                        return "The request had validation errors";
                default:
                    return "Bad request";
            }
        }

        private string GetStatusFromErrorStatusType(ErrorStatusType errorStatusType)
        {
            switch (errorStatusType)
            {
                    case ErrorStatusType.Failure:
                        return "Failure";
                default:
                    return "Success";
            }
        }


    }

    public enum ErrorType
    {
        ValidationError,
        FormatError,
        Unauthorized,
        NotExist,
        Unknown
    }

    public enum ErrorStatusType
    {
        Success,
        Failure
    }
}
