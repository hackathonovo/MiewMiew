using AutoMapper;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using MiewMiew.Dto;
using MiewMiew.Helpers;
using MiewMiew.Models;
using MiewMiew.Repository;
using MiewMiew.Rescuer.Model;
using MiewMiew.Services.Interfaces;
using Shared.Dto.RequestDto;
using Shared.Dto.ResponseDto;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace MiewMiew.Controllers
{
	[Route("api/[controller]")]
	public class UsersController : Controller
	{
		private readonly IMembershipService _membershipService;
		private readonly IUserRepository _userRepository;

		public UsersController(IMembershipService membershipService, IUserRepository userRepository)
		{
			_membershipService = membershipService;
			_userRepository = userRepository;
		}


		[HttpPost("login")]
		[Produces(typeof(UserToken))]
		public IActionResult Login([FromBody] LoginDto loginDto)
		{
			if (loginDto?.Username == null || loginDto.Password == null)
				return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.FormatError));
			var result = _membershipService.Login(loginDto.Username, loginDto.Password);
			if (result.Authenticated != true)
				return BadRequest(
					ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError, "Wrong username or password"));
			return Ok(result);
		}

		[HttpPost("register")]
		[Produces(typeof(MessageDto))]
		public IActionResult Register([FromBody] RegisterDto registerDto)
		{
			if (registerDto == null)
			{
				return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.FormatError));
			}
			var result = _membershipService.Register(registerDto);
			if (result.Status != true)
				return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError, result.Message));
			return Ok(result);
		}


		[HttpPost("addAvailability")]
		[Produces(typeof(UserDto))]
		public IActionResult AddAvailabilityToUser([FromBody] AvailableDto dto)
		{
			if (ModelState.IsValid)
			{
				_userRepository.AddAvailableTimeForUser(Mapper.Map<AvailableDto, Dostupan>(dto));
				var us = _userRepository.GetUserById(dto.KorisnikId);
				return Ok(Mapper.Map<AspNetUsers, UserDto>(us));
			}
			return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError,
				"Vrijeme od,Vrijeme do i korisnik su obavezna polja"));
		}

		[HttpPost("addUnavailability")]
		[Produces(typeof(UserDto))]
		public IActionResult AddUnavailabilityToUser([FromBody] UnavailableDto dto)
		{
			if (ModelState.IsValid)
			{
				_userRepository.AddUnavailableTimeForUser(Mapper.Map<UnavailableDto, Nedostupan>(dto));
				return Ok(Mapper.Map<AspNetUsers, UserDto>(_userRepository.GetUserById(dto.KorisnikId)));
			}
			return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError,
				"Vrijeme od,Vrijeme do i korisnik su obavezna polja"));
		}


		[Authorize("Bearer")]
		[HttpGet("refreshToken")]
		[Produces(typeof(UserToken))]
		public IActionResult RefreshToken()
		{
			return Ok(_membershipService.RefreshTokens(User.Identity.Name));
		}
	}
}