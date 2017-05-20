package hr.miewmiew.MiewMiew.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hr.miewmiew.MiewMiew.data.repository.jpa.AspnetusersJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetusersEntity;
import hr.miewmiew.MiewMiew.dtomodel.AspnetusersEntityDto;

@RestController
@RequestMapping("/api/user")
public class AspnetusersController {
	
	@Autowired
	private AspnetusersJpaRepository aspnetusersJpaRepository;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<AspnetusersEntityDto>> getAll(HttpServletRequest request) {
		try {
			List<AspnetusersEntity> users;
			List<AspnetusersEntityDto> usersDto = new ArrayList<>();
			try {
				users = aspnetusersJpaRepository.findAll();
				for (AspnetusersEntity user : users) {
					usersDto.add(new AspnetusersEntityDto(user));
				}
			} catch (Exception e) {
				return new ResponseEntity<List<AspnetusersEntityDto>>(usersDto, HttpStatus.OK);
			}
			return new ResponseEntity<List<AspnetusersEntityDto>>(usersDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AspnetusersEntityDto> getById(HttpServletRequest request, @PathVariable("id") String id) {
		try {
			List<AspnetusersEntity> users;
			try {
				users = aspnetusersJpaRepository.findById(id);
			} catch (Exception e) {
				return new ResponseEntity<AspnetusersEntityDto>(new AspnetusersEntityDto(), HttpStatus.OK);
			}
			AspnetusersEntityDto userDto = null;
			if (users != null && users.size() > 0) {
				userDto = new AspnetusersEntityDto(users.get(0));
			}
			return new ResponseEntity<AspnetusersEntityDto>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
