using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MiewMiew.Dto;

namespace MiewMiew.Helpers
{
    public static class ErrorMessageCreator
    {
        private static ErrorMessageDto CreateBadFormatMessage()
        {
            return new ErrorMessageDto(ErrorType.FormatError, "Request is in bad format");
        }

        private static ErrorMessageDto CreateErrorMessageForUnauthorizedRequest()
        {
            return new ErrorMessageDto(ErrorType.Unauthorized, "You have no permission to access data");
        }

        private static ErrorMessageDto CreatErrorMessageForUnknownRequest(string message = "")
        {
            string msg = "There was problem with your request";
            if (!String.IsNullOrEmpty(message))
            {
                msg = message;
            }
            return new ErrorMessageDto(ErrorType.Unknown, msg);
        }

        public static ErrorMessageDto GenerateErrorMessage(ErrorType errorType, string message = "")
        {
            switch (errorType)
            {
                case ErrorType.FormatError:
                    return CreateBadFormatMessage();
                case ErrorType.NotExist:
                    return new ErrorMessageDto(ErrorType.NotExist, message);
                case ErrorType.Unauthorized:
                    return CreateErrorMessageForUnauthorizedRequest();
                case ErrorType.ValidationError:
                    return new ErrorMessageDto(ErrorType.ValidationError, message);
                default:
                    return CreatErrorMessageForUnknownRequest(message);
            }
        }
    }
}
