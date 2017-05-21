using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MiewMiew.Dto
{
	public class SmsDto
	{
		public string phone { get; set; }
		public string message { get; set; }
		public string key { get; set; }

		public SmsDto()
		{
			key = "b89341b73cb39f41ef35f60f93a928c1c0dd636fa4johlMBvUJgpugtiZkeijfvR";

		}
	}
}
