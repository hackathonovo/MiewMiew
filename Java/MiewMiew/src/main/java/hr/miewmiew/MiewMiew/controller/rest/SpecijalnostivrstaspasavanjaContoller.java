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

import hr.miewmiew.MiewMiew.data.repository.jpa.SpecijalnostiJpaRepository;
import hr.miewmiew.MiewMiew.data.repository.jpa.SpecijalnostivrstaspasavanjaJpaRepository;
import hr.miewmiew.MiewMiew.data.repository.jpa.VrstaspasavanjaJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SpecijalnostivrstaspasavanjaEntity;
import hr.miewmiew.MiewMiew.dtomodel.SpecijalnostiVrstaIdOnly;
import hr.miewmiew.MiewMiew.dtomodel.SudioniciEntityDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/specijalnostiVrstaSpasavanja")
public class SpecijalnostivrstaspasavanjaContoller {
	
	@Autowired
	private SpecijalnostiJpaRepository specijalnostiJpaRepository;
	
	@Autowired
	private VrstaspasavanjaJpaRepository vrstaspasavanjaJpaRepository;
	
	@Autowired
	private SpecijalnostivrstaspasavanjaJpaRepository specijalnostivrstaspasavanjaJpaRepository;
	
	@RequestMapping(value = "/Add/{vrstaSpasavanjaId}/{specijalnostId}", method = RequestMethod.GET)
	public ResponseEntity<SudioniciEntityDto> addSpasavanjeVrsta(HttpServletRequest request,
			@PathVariable("vrstaSpasavanjaId") String vrstaSpasavanjaId,
			@PathVariable("specijalnostId") String specijalnostId) {
		try {
			SpecijalnostivrstaspasavanjaEntity specijalnostVrsta = new SpecijalnostivrstaspasavanjaEntity();
			
			specijalnostVrsta
					.setSpecijalnosti(specijalnostiJpaRepository.findById(Integer.parseInt(specijalnostId)).get(0));
			specijalnostVrsta.setVrstaspasavanja(
					vrstaspasavanjaJpaRepository.findById(Integer.parseInt(vrstaSpasavanjaId)).get(0));
			specijalnostivrstaspasavanjaJpaRepository.save(specijalnostVrsta);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<SpecijalnostiVrstaIdOnly>> getAll(HttpServletRequest request) {
		try {
			List<SpecijalnostiVrstaIdOnly> specijalnostiVrstaIdOnly = new ArrayList<>();
			List<SpecijalnostivrstaspasavanjaEntity> specijalnostiVrsta = specijalnostivrstaspasavanjaJpaRepository
					.findAll();
			for (SpecijalnostivrstaspasavanjaEntity s : specijalnostiVrsta) {
				specijalnostiVrstaIdOnly.add(new SpecijalnostiVrstaIdOnly(s));
			}
			return new ResponseEntity<List<SpecijalnostiVrstaIdOnly>>(specijalnostiVrstaIdOnly, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/Delete/{vrstaSpasavanjaId}/{specijalnostId}", method = RequestMethod.GET)
	public ResponseEntity<SudioniciEntityDto> deleteSpasavanjeVrsta(HttpServletRequest request,
			@PathVariable("vrstaSpasavanjaId") String vrstaSpasavanjaId,
			@PathVariable("specijalnostId") String specijalnostId) {
		try {
			SpecijalnostivrstaspasavanjaEntity specijalnostVrsta = new SpecijalnostivrstaspasavanjaEntity();
			
			List<SpecijalnostivrstaspasavanjaEntity> specijalnostiVrsta = specijalnostivrstaspasavanjaJpaRepository
					.findAll();
			for (SpecijalnostivrstaspasavanjaEntity s : specijalnostiVrsta) {
				if (s.getSpecijalnosti().getId() == Integer.parseInt(specijalnostId)
						&& s.getVrstaspasavanja().getId() == s.getVrstaspasavanja().getId()) {
					specijalnostVrsta.setId(s.getId());
				}
			}
			specijalnostVrsta
					.setSpecijalnosti(specijalnostiJpaRepository.findById(Integer.parseInt(specijalnostId)).get(0));
			specijalnostVrsta.setVrstaspasavanja(
					vrstaspasavanjaJpaRepository.findById(Integer.parseInt(vrstaSpasavanjaId)).get(0));
			specijalnostivrstaspasavanjaJpaRepository.delete(specijalnostVrsta);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
