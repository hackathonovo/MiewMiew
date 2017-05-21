using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using AutoMapper;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using MiewMiew.Dto;
using MiewMiew.Helpers;
using MiewMiew.Models;
using MiewMiew.RescueAction;
using MiewMiew.RescueAction.Models;
using MiewMiew.Services;

namespace MiewMiew.Controllers
{
	[Produces("application/json")]
	[Route("api/[controller]")]
	public class RescuerActionsController : Controller
	{
		private readonly IRescuersService _rescuersService;
		private readonly IRescuePickerAlgorithm _rescuePickerAlgorithm;

		public RescuerActionsController(IRescuersService rescuersService, IRescuePickerAlgorithm rescuePickerAlgorithm)
		{
			_rescuersService = rescuersService;
			_rescuePickerAlgorithm = rescuePickerAlgorithm;
		}

		[Produces(typeof(IEnumerable<RescueActionDto>))]
		[HttpGet("getAll")]
		public IActionResult GetAll()
		{
			var actions = _rescuersService.GetAllActions();
			return Ok(Mapper.Map<IEnumerable<AkcijaSpasavanje>, IEnumerable<RescueActionDto>>(actions));
		}

		[HttpGet("{id}")]
		[Produces(typeof(RescueActionDto))]
		public IActionResult GetById(int id)
		{
			var action = _rescuersService.GetActionById(id);
			if (action == null)
			{
				return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.Unknown));
			}
			return Ok(Mapper.Map<AkcijaSpasavanje, RescueActionDto>(action));
		}

		[HttpGet("fetchMine")]
		[Produces(typeof(IEnumerable<RescueActionDto>))]
		public IActionResult Fetch_mine(string userId)
		{
			var actions = _rescuersService.GetActionsByUserId(userId);
			return Ok(Mapper.Map<IEnumerable<AkcijaSpasavanje>, IEnumerable<RescueActionDto>>(actions));
		}

		[HttpGet("fetchMineRequests/{userId}")]
		[Produces(typeof(SudioniciDto))]
		public IActionResult Fetch_mine_Requests(string userId)
		{
			return Ok(Mapper.Map<IEnumerable<Sudionici>, IEnumerable<SudioniciDto>>(_rescuersService.GetMineRequests(userId)));
		}

		[HttpPost("acceptMyRequest/{userId}/{actionId}")]
		public IActionResult AcceptMine(string userId,int actionId)
		{
			var result = _rescuersService.AcceptMyInvitation(userId, actionId);
			if (result != null)
			{
				return Ok(Mapper.Map < Sudionici, SudioniciDto > (result));
			}
			return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.NotExist));
		}
		[HttpPost("changeActionStatus/{actionId}/{rescueTypeEnum}")]
		public IActionResult ChangeActionStatus(int actionId, RescueTypeEnum rescueTypeEnum)
		{
			_rescuersService.UpdateActionStatus(actionId, rescueTypeEnum);
			return Ok();
		}

		[HttpPost("save")]
		[Authorize("Bearer")]
		[Produces(typeof(RescueActionDto))]
		public IActionResult Save([FromBody] RescueActionDto dto)
		{
			var action = Mapper.Map<RescueActionDto, AkcijaSpasavanje>(dto);
			if (!ModelState.IsValid)
			{
				return BadRequest(ErrorMessageCreator.GenerateErrorMessage(ErrorType.ValidationError,
					"Naziv, opis, potraga are required fields"));
			}
			AkcijaSpasavanje actionNew = null;

			if (dto.Id != 0)
			{
				actionNew = _rescuersService.EditAction(dto, dto.Id);
			}
			else
			{
				actionNew = _rescuersService.AddAction(action, User.Identity.Name);
			}
			return Ok(Mapper.Map<AkcijaSpasavanje, RescueActionDto>(actionNew));
		}

		[HttpGet("getAvailableUsers/{actionId}")]
		[Produces(typeof(IEnumerable<UserPickerDto>))]
		public IActionResult GenerateUsersForAction(int actionId)
		{
			var result = _rescuePickerAlgorithm.FindBestUsers(actionId);
			
			
			return Ok(result);
		}
	}
}