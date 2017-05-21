package hr.miewmiew.MiewMiew.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hr.miewmiew.MiewMiew.data.repository.jpa.AspnetusersJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetusersEntity;
import hr.miewmiew.MiewMiew.dtomodel.AspnetusersEntityDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
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
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<AspnetusersEntityDto> update(HttpServletRequest request,
			@RequestBody AspnetusersEntityDto aspnetusersEntityDto) {
		try {
			if (aspnetusersEntityDto == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			List<AspnetusersEntity> users;
			try {
				users = aspnetusersJpaRepository.findById(aspnetusersEntityDto.getId());
			} catch (Exception e) {
				return new ResponseEntity<AspnetusersEntityDto>(new AspnetusersEntityDto(), HttpStatus.OK);
			}
			if (users != null && users.size() > 0) {
				AspnetusersEntity user = users.get(0);
				user.setEmail(aspnetusersEntityDto.getEmail());
				user.setPhonenumber(aspnetusersEntityDto.getPhonenumber());
				user.setUsername(aspnetusersEntityDto.getUserName());
				user.setCreated(aspnetusersEntityDto.getCreated());
				user.setIme(aspnetusersEntityDto.getIme());
				user.setPrezime(aspnetusersEntityDto.getPrezime());
				user.setRazina(aspnetusersEntityDto.getRazina());
				user.setLatitude(aspnetusersEntityDto.getLatitude());
				user.setLongitude(aspnetusersEntityDto.getLongitude());
				AspnetusersEntity userReturned = aspnetusersJpaRepository.save(user);
				return new ResponseEntity<AspnetusersEntityDto>(new AspnetusersEntityDto(userReturned), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
