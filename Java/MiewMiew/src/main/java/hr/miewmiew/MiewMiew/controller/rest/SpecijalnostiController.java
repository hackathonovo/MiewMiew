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

import hr.miewmiew.MiewMiew.data.repository.jpa.SpecijalnostiJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SpecijalnostiEntity;
import hr.miewmiew.MiewMiew.dtomodel.SpecijalnostiEntityDto;

@RestController
@RequestMapping("/api/specijalnosti")
public class SpecijalnostiController {
	
	@Autowired
	private SpecijalnostiJpaRepository specijalnostiJpaRepository;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<SpecijalnostiEntityDto>> getAll(HttpServletRequest request) {
		try {
			List<SpecijalnostiEntityDto> specijalnostiDto = new ArrayList<>();
			List<SpecijalnostiEntity> specijalnosti = null;
			try {
				specijalnosti = specijalnostiJpaRepository.findAll();
			} catch (Exception e) {
				return new ResponseEntity<List<SpecijalnostiEntityDto>>(specijalnostiDto, HttpStatus.OK);
			}
			
			for (SpecijalnostiEntity s : specijalnosti) {
				specijalnostiDto.add(new SpecijalnostiEntityDto(s));
			}
			return new ResponseEntity<List<SpecijalnostiEntityDto>>(specijalnostiDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SpecijalnostiEntityDto> getById(HttpServletRequest request, @PathVariable("id") String id) {
		try {
			SpecijalnostiEntityDto specijalnostDto = null;
			List<SpecijalnostiEntity> specijalnosti = null;
			try {
				specijalnosti = specijalnostiJpaRepository.findById(Integer.parseInt(id));
				if (specijalnosti != null && specijalnosti.size() > 0) {
					specijalnostDto = new SpecijalnostiEntityDto(specijalnosti.get(0));
				}
			} catch (Exception e) {
				return new ResponseEntity<SpecijalnostiEntityDto>(new SpecijalnostiEntityDto(), HttpStatus.OK);
			}
			
			return new ResponseEntity<SpecijalnostiEntityDto>(specijalnostDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<SpecijalnostiEntityDto> save(@RequestBody SpecijalnostiEntityDto specijalnostDto) {
		try {
			SpecijalnostiEntity specijalnost = new SpecijalnostiEntity();
			specijalnost.setNaziv(specijalnostDto.getNaziv());
			SpecijalnostiEntity specijalnostReturn = specijalnostiJpaRepository.save(specijalnost);
			return new ResponseEntity<SpecijalnostiEntityDto>(new SpecijalnostiEntityDto(specijalnostReturn),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<SpecijalnostiEntityDto> update(@RequestBody SpecijalnostiEntityDto specijalnostDto) {
		try {
			SpecijalnostiEntity specijalnost = new SpecijalnostiEntity();
			specijalnost.setNaziv(specijalnostDto.getNaziv());
			specijalnost.setId(specijalnostDto.getId());
			SpecijalnostiEntity specijalnostReturn = specijalnostiJpaRepository.save(specijalnost);
			return new ResponseEntity<SpecijalnostiEntityDto>(new SpecijalnostiEntityDto(specijalnostReturn),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
