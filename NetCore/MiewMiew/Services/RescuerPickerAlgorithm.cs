using System;
using System.Collections.Generic;
using System.Linq;
using MiewMiew.Dto;
using MiewMiew.Models;
using MiewMiew.Repository;
using MiewMiew.RescueAction;
using Remotion.Linq.Clauses.ExpressionVisitors;

namespace MiewMiew.Services
{
	public interface IRescuePickerAlgorithm
	{
		IEnumerable<AspNetUsers> FindBestUsers(int actionId, double longitude);
	}

	public class RescuerPickerAlgorithm : IRescuePickerAlgorithm
	{
		private readonly IRescuersService _rescuersService;
		private readonly IUserRepository _userRepository;


		public RescuerPickerAlgorithm(IRescuersService rescuersService, IUserRepository userRepository)
		{
			_rescuersService = rescuersService;
			_userRepository = userRepository;
		}

		public IEnumerable<AspNetUsers> FindBestUsers(int actionId)
		{
			var userList = FilterUnavailableUsers();
			var rescueAction = _rescuersService.GetActionById(actionId);
			var rescueActionVjestine = rescueAction.VrstaSpasavanja;

			return SortByDistanceAndVjestinama(userList, rescueActionVjestine, (double) rescueAction.Latitude, (double) rescueAction.Longitude);
		}

		private IEnumerable<AspNetUsers> FilterUnavailableUsers()
		{
			var userList = _userRepository.GetAll();
			userList = userList.Where(u => !_rescuersService.GetAllActionsActiveForUser(u.Id).Any() || _userRepository.IsUserUnavailable(u.Id, DateTime.Now));
		//	userList = SortByDistance(userList);
			return userList;
		}

		private IEnumerable<AspNetUsers> SortByDistanceAndVjestinama(IEnumerable<AspNetUsers> aspNetUsers,VrstaSpasavanja rescueActionVjestina, double latitude, double longitude)
		{
			return aspNetUsers.OrderByDescending(
				u => u.VjestineKorisnika.Any(uu => uu.SpecijalnostId == rescueActionVjestina.Id)).ThenBy(u => FindDistanceBetweenLocations(latitude, longitude, (double)u.Latitude, (double)u.Longitude));
		}

		private double FindDistanceBetweenLocations(double lat1, double long1, double lat2, double long2)
		{
			double D2R = Math.PI / 180;
			double dlong = (long2 - long1) * D2R;
			double dlat = (lat2 - lat1) * D2R;
			double a = Math.Pow(Math.Sin(dlat / 2.0), 2) + Math.Cos(lat1 * D2R) * Math.Cos(lat2 * D2R) * Math.Pow(Math.Sin(dlong / 2.0), 2);
			double c = 2 * Math.Atan2(Math.Sqrt(a), Math.Sqrt(1 - a));
			return 6367 * c * 1000;
		}
	}
}
