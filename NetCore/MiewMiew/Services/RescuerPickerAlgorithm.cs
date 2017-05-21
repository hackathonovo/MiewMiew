using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using MiewMiew.Dto;
using MiewMiew.Models;
using MiewMiew.Repository;
using MiewMiew.RescueAction;

namespace MiewMiew.Services
{
	public class RescuerPickerAlgorithm : IRescuePickerAlgorithm
	{
		private readonly IRescuersService _rescuersService;
		private readonly IUserRepository _userRepository;


		public RescuerPickerAlgorithm(IRescuersService rescuersService, IUserRepository userRepository)
		{
			_rescuersService = rescuersService;
			_userRepository = userRepository;
		}

		public IEnumerable<UserPickerDto> FindBestUsers(int actionId)
		{
			var userList = FilterUnavailableUsers();
			var rescueAction = _rescuersService.GetActionById(actionId);
			var rescueActionVjestine = rescueAction.VrstaSpasavanja;
			if (rescueAction.VrstaSpasavanjaId == null)
			{
				var users =  SortByDistance(userList, (double) rescueAction.Latitude, (double) rescueAction.Longitude, (DateTime)rescueAction.Vrijeme);
				return MapUsers(users, (DateTime)rescueAction.Vrijeme, (double)rescueAction.Latitude, (double)rescueAction.Longitude);
			}
			var us = SortByDistanceAndVjestinama(userList, rescueActionVjestine, (double)rescueAction.Latitude, (double)rescueAction.Longitude, (DateTime)rescueAction.Vrijeme);
			return MapUsers(us, (DateTime)rescueAction.Vrijeme, (double)rescueAction.Latitude, (double)rescueAction.Longitude);
		}


		private IEnumerable<AspNetUsers> FilterUnavailableUsers()
		{
			var userList = _userRepository.GetAll();
			userList = userList.Where(u => !_rescuersService.GetAllActionsActiveForUser(u.Id).Any() || _userRepository.IsUserUnavailable(u.Id, DateTime.Now));
			return userList;
		}

		private IEnumerable<UserPickerDto> MapUsers(IEnumerable<AspNetUsers> userList, DateTime dateTime, double latitude, double longitude)
		{
			var mappedUsers = Mapper.Map<IEnumerable<AspNetUsers>, IEnumerable<UserPickerDto>>(userList);
			foreach (var user in mappedUsers)
			{
				user.IsAvailable = _userRepository.IsUserAvailable(user.Id, dateTime);
				user.Udaljenost = FindDistanceBetweenLocations(latitude, longitude, (double)user.Latitude, (double)user.Longitude);
			}
			return mappedUsers;
		}

		private IEnumerable<AspNetUsers> SortByDistanceAndVjestinama(IEnumerable<AspNetUsers> aspNetUsers,VrstaSpasavanja rescueActionVjestina, double latitude, double longitude,DateTime dateTime)
		{
			return aspNetUsers.OrderByDescending(u => _userRepository.IsUserAvailable(u.Id, dateTime)).ThenByDescending(
				u => u.VjestineKorisnika.Any(uu => uu.SpecijalnostId == rescueActionVjestina.Id)).ThenBy(u => FindDistanceBetweenLocations(latitude, longitude, (double)u.Latitude, (double)u.Longitude));
		}

		private IEnumerable<AspNetUsers> SortByDistance(IEnumerable<AspNetUsers> userList, double latitude, double longitude, DateTime dateTime)
		{
			return userList.OrderByDescending(u => _userRepository.IsUserAvailable(u.Id, dateTime)).ThenBy(u => FindDistanceBetweenLocations(latitude, longitude, (double)u.Latitude, (double)u.Longitude));
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
