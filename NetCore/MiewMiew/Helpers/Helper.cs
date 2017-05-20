using System;
using Newtonsoft.Json;

namespace MiewMiew.Helpers
{
    public class Helper
    {
        public static double DatetimeToMiliseconds(DateTime dateTime)
        {
            return dateTime.ToUniversalTime().Subtract(
                new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc)
                ).TotalMilliseconds;
        }

        public static T MapJsonStringToObject<T>(string json)
        {
                var result = JsonConvert.DeserializeObject<T>(json);
                return result;
        }

        public static string MapObjectToJsonString(Object obj)
        {
            var result = JsonConvert.SerializeObject(obj);
            return result;
        }

        public static bool IsJson(string input)
        {
            input = input.Trim();
            return input.StartsWith("{") && input.EndsWith("}")
                   || input.StartsWith("[") && input.EndsWith("]");
        }
    }
}
