package hr.miewmiew.MiewMiew.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hr.miewmiew.MiewMiew.data.repository.jpa.VjestinekorisnikaJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.VjestinekorisnikaEntity;
import hr.miewmiew.MiewMiew.dtomodel.SpecijalnostiEntityDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/vjestine")
public class VjestineKorisnikaController {
	
	@Autowired
	private VjestinekorisnikaJpaRepository vjestineKorisnikaJpaRepository;
	
	@RequestMapping(value = "/korisnik/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SpecijalnostiEntityDto>> getVjestineById(HttpServletRequest request,
			@PathVariable("userId") String userId) {
		try {
			List<VjestinekorisnikaEntity> vjestineKorisnika = vjestineKorisnikaJpaRepository.findByAspnetusers(userId);
			List<SpecijalnostiEntityDto> specijalnostiDto = new ArrayList<>();
			for (VjestinekorisnikaEntity v : vjestineKorisnika) {
				specijalnostiDto.add(new SpecijalnostiEntityDto(v.getSpecijalnosti()));
			}
			return new ResponseEntity<List<SpecijalnostiEntityDto>>(specijalnostiDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
