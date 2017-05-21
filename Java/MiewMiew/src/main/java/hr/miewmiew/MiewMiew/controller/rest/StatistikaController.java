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

import hr.miewmiew.MiewMiew.data.repository.jpa.AkcijaspasavanjeJpaRepository;
import hr.miewmiew.MiewMiew.data.repository.jpa.SudioniciJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AkcijaspasavanjeEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntity;
import hr.miewmiew.MiewMiew.dtomodel.StatistikaDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/statistika")
public class StatistikaController {
	
	@Autowired
	private AkcijaspasavanjeJpaRepository akcijaspasavanjeJpaRepository;
	
	@Autowired
	private SudioniciJpaRepository sudioniciJpaRepository;
	
	@RequestMapping(value = "/akcije", method = RequestMethod.GET)
	public ResponseEntity<List<StatistikaDto>> getAll(HttpServletRequest request) {
		try {
			List<AkcijaspasavanjeEntity> akcijeSpasavanja = akcijaspasavanjeJpaRepository.findAll();
			List<StatistikaDto> statistikaDto = new ArrayList<>();
			for (AkcijaspasavanjeEntity a : akcijeSpasavanja) {
				StatistikaDto statistikaObjekt = new StatistikaDto();
				statistikaObjekt.setId(a.getId());
				statistikaObjekt.setNazivAkcije(a.getNaziv());
				List<SudioniciEntity> sudionici = sudioniciJpaRepository.findById(a.getId());
				statistikaObjekt.setBrojSudionika(sudionici.size());
				statistikaObjekt.setVrstaSpasavanjaNaziv(a.getVrstaspasavanja().getVrsta());
				statistikaObjekt.setNazivLokacije(a.getNazivlokacije());
				statistikaObjekt.setVrijemeAkcije(a.getVrijeme());
				statistikaObjekt.setVoditelj(a.getAspnetusers().getIme() + a.getAspnetusers().getPrezime());
				if (a.getFazazivotnogciklusa() != null) {
					switch (a.getFazazivotnogciklusa()) {
						case 1:
							statistikaObjekt.setStatus("Created");
							break;
						case 2:
							statistikaObjekt.setStatus("Pending");
							break;
						case 3:
							statistikaObjekt.setStatus("In Progress");
							break;
						case 4:
							statistikaObjekt.setStatus("Finished Successfully");
							break;
						case 5:
							statistikaObjekt.setStatus("Finished Failed");
							break;
					}
				} else {
					statistikaObjekt.setStatus(" ");
				}
				statistikaDto.add(statistikaObjekt);
			}
			return new ResponseEntity<List<StatistikaDto>>(statistikaDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
