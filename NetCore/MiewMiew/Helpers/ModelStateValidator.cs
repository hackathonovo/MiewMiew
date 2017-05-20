using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace MiewMiew.Helpers
{
    public class ModelStateValidator<T>
    {
        public static List<ValidationResult> CheckIfModelStateIsValid(T registerDto)
        {
            var context = new ValidationContext(registerDto, serviceProvider: null, items: null);
            var results = new List<ValidationResult>();

            var smth = Validator.TryValidateObject(registerDto, context, results, true);
            return results;
        }

    }
}
