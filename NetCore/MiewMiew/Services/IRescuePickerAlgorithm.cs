using System.Collections.Generic;
using MiewMiew.Dto;
using MiewMiew.Models;

namespace MiewMiew.Services
{
	public interface IRescuePickerAlgorithm
	{
		IEnumerable<UserPickerDto> FindBestUsers(int actionId);
	}
}