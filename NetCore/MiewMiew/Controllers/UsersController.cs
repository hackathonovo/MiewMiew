using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using MiewMiew.Dto;
using MiewMiew.Helpers;
using MiewMiew.Services.Interfaces;
using Shared.Dto.RequestDto;
using Shared.Dto.ResponseDto;
using SL.Core.Service.Interfaces;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace MiewMiew.Controllers
{
        [Route("api/[controller]")]
        public class UsersController : Controller
        {
            private readonly IMembershipService _membershipService;

            public UsersController(IMembershipService membershipService)
            {
                _membershipService = membershipService;
            }


            [HttpPost("login")]
            [Produces(typeof(UserToken))]
            public IActionResult Login([FromBody] LoginDto loginDto)
            {
                if (loginDto?.Username == null || loginDto.Password == null)
                    return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.FormatError));
                var result = _membershipService.Login(loginDto.Username, loginDto.Password);
                if (result.Authenticated != true) return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError, "Wrong username or password"));
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
                if (result.Status != true) return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError, result.Message));
                return Ok(result);

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
