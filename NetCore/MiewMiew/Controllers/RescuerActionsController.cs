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

namespace MiewMiew.Controllers
{
	[Produces("application/json")]
	[Route("api/[controller]")]
	public class RescuerActionsController : Controller
	{
		private readonly IRescuersService _rescuersService;

		public RescuerActionsController(IRescuersService rescuersService)
		{
			_rescuersService = rescuersService;
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
			Enum.TryParse(dto.RescueType, out RescueTypeEnum type);
			action.VrstaSpasavanjaId = (int) type;
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
	}
}