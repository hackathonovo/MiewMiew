package hr.miewmiew.MiewMiew.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hr.miewmiew.MiewMiew.data.repository.jpa.SudioniciJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntity;
import hr.miewmiew.MiewMiew.dtomodel.SudioniciEntityDto;
import hr.miewmiew.MiewMiew.dtomodel.SudioniciUpdateAddDto;

@RestController
@RequestMapping("/api/sudionici")
public class SudioniciController {
	
	@Autowired
	private SudioniciJpaRepository sudioniciJpaRepository;
	
	@RequestMapping(value = "/Add/{akcijaId}/{korisnikId}", method = RequestMethod.GET)
	public ResponseEntity<SudioniciEntityDto> addSudionik(HttpServletRequest request,
			@PathVariable("akcijaId") String akcijaId, @PathVariable("korisnikId") String korisnikId) {
		try {
			SudioniciEntity sudionik = new SudioniciEntity();
			sudionik.setAkcijaspasavanjaid(Integer.parseInt(akcijaId));
			sudionik.setKorisnikid(korisnikId);
			SudioniciEntity sudionikReturned = sudioniciJpaRepository.save(sudionik);
			
			return new ResponseEntity<SudioniciEntityDto>(new SudioniciEntityDto(sudionikReturned), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/Delete/{akcijaId}/{korisnikId}", method = RequestMethod.GET)
	public ResponseEntity<SudioniciEntityDto> deleteSudionik(HttpServletRequest request,
			@PathVariable("akcijaId") String akcijaId, @PathVariable("korisnikId") String korisnikId) {
		try {
			SudioniciEntity sudionik = new SudioniciEntity();
			sudionik.setAkcijaspasavanjaid(Integer.parseInt(akcijaId));
			sudionik.setKorisnikid(korisnikId);
			sudioniciJpaRepository.delete(sudionik);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ResponseEntity<SudioniciUpdateAddDto> update(HttpServletRequest request,
			@RequestBody SudioniciUpdateAddDto sudioniciUpdateAddDto) {
		try {
			if (sudioniciUpdateAddDto == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			SudioniciEntity sudionik = new SudioniciEntity();
			sudionik.setKorisnikid(sudioniciUpdateAddDto.getKorisnikid());
			sudionik.setAkcijaspasavanjaid(sudioniciUpdateAddDto.getAkcijaspasavanjaid());
			sudionik.setLatitude(sudioniciUpdateAddDto.getLatitude());
			sudionik.setLongitude(sudioniciUpdateAddDto.getLongitude());
			SudioniciEntity sudionikReturned = sudioniciJpaRepository.save(sudionik);
			
			SudioniciUpdateAddDto sudionikReturnedDto = new SudioniciUpdateAddDto(sudionikReturned);
			
			return new ResponseEntity<SudioniciUpdateAddDto>(sudionikReturnedDto, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<SudioniciUpdateAddDto>> getAll(HttpServletRequest request) {
		try {
			List<SudioniciUpdateAddDto> sudioniciUpdateAddDto = new ArrayList<>();
			List<SudioniciEntity> sudionici;
			try {
				sudionici = sudioniciJpaRepository.findAll();
				for (SudioniciEntity s : sudionici) {
					sudioniciUpdateAddDto.add(new SudioniciUpdateAddDto(s));
				}
			} catch (Exception e) {
				return new ResponseEntity<List<SudioniciUpdateAddDto>>(sudioniciUpdateAddDto, HttpStatus.OK);
			}
			
			return new ResponseEntity<List<SudioniciUpdateAddDto>>(sudioniciUpdateAddDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
