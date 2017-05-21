package hr.miewmiew.MiewMiew.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hr.miewmiew.MiewMiew.data.repository.jpa.AspnetusersJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetusersEntity;
import hr.miewmiew.MiewMiew.dtomodel.AspnetusersEntityDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private AspnetusersJpaRepository aspnetusersJpaRepository;
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<List<AspnetusersEntityDto>> getVehicleByType(HttpServletRequest request) {
		try {
			List<AspnetusersEntity> users = aspnetusersJpaRepository.findAll();
			// List<AspnetusersEntity> users =
			// aspnetusersJpaRepository.findByEmail("nn@nn.com");
			List<AspnetusersEntityDto> usersDto = new ArrayList<>();
			for (AspnetusersEntity user : users) {
				usersDto.add(new AspnetusersEntityDto(user));
			}
			return new ResponseEntity<List<AspnetusersEntityDto>>(usersDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
