using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Security.Principal;
using AutoMapper;
using Microsoft.IdentityModel.Tokens;
using Shared.Dto;
using Shared.Dto.RequestDto;
using Shared.Dto.ResponseDto;
using SL.Core.Authentication;
using SL.Core.Service.Interfaces;
using Microsoft.Extensions.Localization;
using MiewMiew;
using MiewMiew.Helpers;
using MiewMiew.Models;
using MiewMiew.Repository;
using MiewMiew.Services.Interfaces;

namespace SL.Core.Service
{
    public class MembershipService : IMembershipService
    {
        private readonly IEncryptionService _encryptionService;
        private readonly IUserRepository _userRepository;
        private readonly TokenAuthOptions _tokenOptions;

        public MembershipService(IEncryptionService encryptionService, IUserRepository userRepository, TokenAuthOptions tokenOptions)
        {


            _encryptionService = encryptionService;
            _userRepository = userRepository;
            _tokenOptions = tokenOptions;
        }

        public UserToken Login(string username, string password)
        {
            var user = _userRepository.GetUserByName(username);
            if (user != null && IsUserValid(user, password))
            {
                DateTime expires = DateTime.UtcNow.AddMinutes(4320);  //TODO Configuration expires
                var userInfo = Mapper.Map<UserInfoDto>(user);
                return new UserToken(true, GetToken(username, expires), Helper.DatetimeToMiliseconds(expires), userInfo);
            }
            return new UserToken("Bad data");
        }

        


        public MessageDto Register(RegisterDto registerDto)
        {

         //   var errors = CheckIfModelStateIsValid(registerDto);
            var errors = ModelStateValidator<RegisterDto>.CheckIfModelStateIsValid(registerDto);
            if (errors.Count != 0)
                return new MessageDto(false, errors[0].ErrorMessage);

            if (_userRepository.GetUserByName(registerDto.Username) != null)
                return new MessageDto(false, "Username is in use");


            var passwordSalt = _encryptionService.CreateSalt();
            var user = CreateUser(registerDto.Username, registerDto.Password, passwordSalt, registerDto.Email);
            _userRepository.AddUser(user);
            return new MessageDto(true,  "Successful registration");
        }

        private AspNetUsers CreateUser(string username, string password, string salt, string email)
        {
            var user = new AspNetUsers
            {
                UserName = username,
                Salt = salt,
                Email = email,
                PasswordHash = _encryptionService.EncryptPassword(password, salt),
                Created = DateTime.Now
            };
            return user;
        }

        public string GetAuthUserFromToken(string token)
        {
            var handler = new JwtSecurityTokenHandler();
            SecurityToken validatedToken;
            handler.ValidateToken(token, Startup.tokenValidationParametars, out validatedToken);
            return validatedToken?.Id;
        }



        #region Validators
        private bool IsPasswordValid(AspNetUsers AspNetUsers, string password)
        {
            return string.Equals(_encryptionService.EncryptPassword(password, AspNetUsers.Salt), AspNetUsers.PasswordHash);
        }

        private bool IsUserValid(AspNetUsers AspNetUsers, string password)
        {
            if (IsPasswordValid(AspNetUsers, password))
            {
                return true;
            }

            return false;
        }
        #endregion

        #region Tokens

        public UserToken RefreshTokens(string userName)
        {
            var user = _userRepository.GetUserByName(userName);
            DateTime expires = DateTime.UtcNow.AddMinutes(4320); //TODO Config expires
            return new UserToken(true, GetToken(userName, expires), Helper.DatetimeToMiliseconds(expires), Mapper.Map<UserInfoDto>(user));
        }


        public string GetToken(string userName, DateTime? expires)
        {
            var handler = new JwtSecurityTokenHandler();

            // Here, you should create or look up an identity for the userName which is being authenticated.
            // For now, just creating a simple generic identity.
            var user = _userRepository.GetUserByName(userName);
            ClaimsIdentity identity = new ClaimsIdentity(new GenericIdentity(user.UserName, "TokenAuth"), new[] { new Claim("UserId", user.UserName, ClaimValueTypes.String), new Claim("Id", user.Id, ClaimValueTypes.String) });
            var descriptor = new SecurityTokenDescriptor
            {
                Issuer = _tokenOptions.Issuer,
                Audience = _tokenOptions.Audience,
                SigningCredentials = _tokenOptions.SigningCredentials,
                Subject = identity,
                Expires = expires

            };

            var securityToken = handler.CreateToken(descriptor);
            return handler.WriteToken(securityToken);
        }
        #endregion
    }
}
