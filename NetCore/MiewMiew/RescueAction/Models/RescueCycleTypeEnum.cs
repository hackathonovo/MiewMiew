using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MiewMiew.RescueAction.Models
{
	public enum RescueCycleTypeEnum
	{
		Created = 1,
		Pending = 2,
		InProgress = 3,
		FinishedSuccessfully = 4,
		FinishedFailed = 5
	}
}
