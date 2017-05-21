package hr.miewmiew.MiewMiew.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hr.miewmiew.MiewMiew.data.repository.jpa.AkcijaspasavanjeJpaRepository;
import hr.miewmiew.MiewMiew.data.repository.jpa.AspnetusersJpaRepository;
import hr.miewmiew.MiewMiew.data.repository.jpa.VrstaspasavanjaJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AkcijaspasavanjeEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetusersEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.VrstaspasavanjaEntity;
import hr.miewmiew.MiewMiew.dtomodel.AkcijaspasavanjeEntityDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/AkcijaSpasavanja")
public class AkcijaSpasavanjeController {
	
	@Autowired
	private AkcijaspasavanjeJpaRepository akcijaspasavanjeJpaRepository;
	
	@Autowired
	private VrstaspasavanjaJpaRepository vrstaspasavanjaJpaRepository;
	
	@Autowired
	private AspnetusersJpaRepository aspnetusersJpaRepository;
	
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
	
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ResponseEntity<AkcijaspasavanjeEntityDto> update(HttpServletRequest request,
			@RequestBody AkcijaspasavanjeEntityDto akcijaspasavanjeEntityDto) {
		try {
			AkcijaspasavanjeEntity akcijeSpasavanja = new AkcijaspasavanjeEntity();
			try {
				akcijeSpasavanja.setId(akcijaspasavanjeEntityDto.getId());
				akcijeSpasavanja.setFazazivotnogciklusa(akcijaspasavanjeEntityDto.getFazazivotnogciklusa());
				akcijeSpasavanja.setLatitude(akcijaspasavanjeEntityDto.getLatitude());
				akcijeSpasavanja.setLongitude(akcijaspasavanjeEntityDto.getLongitude());
				akcijeSpasavanja.setNaziv(akcijaspasavanjeEntityDto.getNaziv());
				akcijeSpasavanja.setNazivlokacije(akcijaspasavanjeEntityDto.getNazivlokacije());
				akcijeSpasavanja.setOpis(akcijaspasavanjeEntityDto.getOpis());
				akcijeSpasavanja.setVrijeme(akcijaspasavanjeEntityDto.getVrijeme());
				akcijeSpasavanja.setPotraga(akcijaspasavanjeEntityDto.getPotraga());
				akcijeSpasavanja.setRadius(akcijaspasavanjeEntityDto.getRadius());
				List<VrstaspasavanjaEntity> vrsteSpasavanja = vrstaspasavanjaJpaRepository
						.findById(akcijaspasavanjeEntityDto.getVrstaspasavanjaId());
				
				akcijeSpasavanja.setVrstaspasavanja(vrsteSpasavanja.get(0));
				
				List<AspnetusersEntity> users = aspnetusersJpaRepository
						.findById(akcijaspasavanjeEntityDto.getVoditeljId());
				akcijeSpasavanja.setAspnetusers(users.get(0));
				akcijaspasavanjeJpaRepository.save(akcijeSpasavanja);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			return new ResponseEntity<AkcijaspasavanjeEntityDto>(new AkcijaspasavanjeEntityDto(akcijeSpasavanja),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
