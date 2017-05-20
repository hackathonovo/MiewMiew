package hr.miewmiew.MiewMiew.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hr.miewmiew.MiewMiew.data.repository.jpa.AkcijaspasavanjeJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AkcijaspasavanjeEntity;
import hr.miewmiew.MiewMiew.dtomodel.AkcijaspasavanjeEntityDto;

@RestController
@RequestMapping("/api/AkcijaSpasavanja/")
public class AkcijaSpasavanjeController {
	
	@Autowired
	private AkcijaspasavanjeJpaRepository akcijaspasavanjeJpaRepository;
	
	@RequestMapping(value = "/GetAll", method = RequestMethod.GET)
	public ResponseEntity<List<AkcijaspasavanjeEntityDto>> getAllAkcijaSpasavanje(HttpServletRequest request) {
		try {
			List<AkcijaspasavanjeEntity> akcijeSpasavanja;
			List<AkcijaspasavanjeEntityDto> akcijeSpasavanjaDto = new ArrayList<>();
			try {
				akcijeSpasavanja = akcijaspasavanjeJpaRepository.findAll();
				
				for (AkcijaspasavanjeEntity a : akcijeSpasavanja) {
					akcijeSpasavanjaDto.add(new AkcijaspasavanjeEntityDto(a));
				}
			} catch (Exception e) {
				return new ResponseEntity<List<AkcijaspasavanjeEntityDto>>(akcijeSpasavanjaDto, HttpStatus.OK);
			}
			return new ResponseEntity<List<AkcijaspasavanjeEntityDto>>(akcijeSpasavanjaDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
