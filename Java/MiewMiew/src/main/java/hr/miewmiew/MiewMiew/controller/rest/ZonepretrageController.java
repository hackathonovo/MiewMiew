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

import hr.miewmiew.MiewMiew.data.repository.jpa.AkcijaspasavanjeJpaRepository;
import hr.miewmiew.MiewMiew.data.repository.jpa.ZonepretrageJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AkcijaspasavanjeEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.ZonepretrageEntity;
import hr.miewmiew.MiewMiew.dtomodel.ZonepretrageDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/zonepretrage")
public class ZonepretrageController {
	
	@Autowired
	private ZonepretrageJpaRepository zonepretrageJpaRepository;
	
	@Autowired
	private AkcijaspasavanjeJpaRepository akcijaspasavanjeJpaRepository;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<ZonepretrageDto>> getAll(HttpServletRequest request) {
		try {
			List<ZonepretrageDto> zoneDto = new ArrayList<>();
			List<ZonepretrageEntity> zone;
			try {
				zone = zonepretrageJpaRepository.findAll();
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			for (ZonepretrageEntity zonepretrageEntity : zone) {
				zoneDto.add(new ZonepretrageDto(zonepretrageEntity));
			}
			return new ResponseEntity<List<ZonepretrageDto>>(zoneDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{akcijaId}", method = RequestMethod.GET)
	public ResponseEntity<List<ZonepretrageDto>> getByAkcijaId(HttpServletRequest request,
			@PathVariable("akcijaId") String akcijaId) {
		try {
			List<ZonepretrageDto> zoneDto = new ArrayList<>();
			List<ZonepretrageEntity> zone;
			try {
				zone = zonepretrageJpaRepository.findByAkcijaId(Integer.parseInt(akcijaId));
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			for (ZonepretrageEntity zonepretrageEntity : zone) {
				zoneDto.add(new ZonepretrageDto(zonepretrageEntity));
			}
			return new ResponseEntity<List<ZonepretrageDto>>(zoneDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/Add", method = RequestMethod.POST)
	public ResponseEntity<ZonepretrageDto> add(HttpServletRequest request,
			@RequestBody ZonepretrageDto zonepretrageDto) {
		try {
			if (zonepretrageDto == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			ZonepretrageEntity zonaPretrage = new ZonepretrageEntity();
			AkcijaspasavanjeEntity akcija = akcijaspasavanjeJpaRepository.findById(zonepretrageDto.getAkcijaId());
			zonaPretrage.setAkcijaspasavanje(akcija);
			zonaPretrage.setNaziv(zonepretrageDto.getNaziv());
			zonaPretrage.setLatitude(zonepretrageDto.getLatitude());
			zonaPretrage.setLongitude(zonepretrageDto.getLongitude());
			ZonepretrageEntity zonaPretrageReturned = zonepretrageJpaRepository.save(zonaPretrage);
			
			return new ResponseEntity<ZonepretrageDto>(new ZonepretrageDto(zonaPretrageReturned), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ResponseEntity<ZonepretrageDto> update(HttpServletRequest request,
			@RequestBody ZonepretrageDto zonepretrageDto) {
		try {
			if (zonepretrageDto == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			ZonepretrageEntity zonaPretrage = new ZonepretrageEntity();
			AkcijaspasavanjeEntity akcija = akcijaspasavanjeJpaRepository.findById(zonepretrageDto.getAkcijaId());
			zonaPretrage.setId(zonepretrageDto.getId());
			zonaPretrage.setAkcijaspasavanje(akcija);
			zonaPretrage.setNaziv(zonepretrageDto.getNaziv());
			zonaPretrage.setLatitude(zonepretrageDto.getLatitude());
			zonaPretrage.setLongitude(zonepretrageDto.getLongitude());
			ZonepretrageEntity zonaPretrageReturned = zonepretrageJpaRepository.save(zonaPretrage);
			
			return new ResponseEntity<ZonepretrageDto>(new ZonepretrageDto(zonaPretrageReturned), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/Delete", method = RequestMethod.POST)
	public ResponseEntity<ZonepretrageDto> delete(HttpServletRequest request,
			@RequestBody ZonepretrageDto zonepretrageDto) {
		try {
			if (zonepretrageDto == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			ZonepretrageEntity zonaPretrage = new ZonepretrageEntity();
			AkcijaspasavanjeEntity akcija = akcijaspasavanjeJpaRepository.findById(zonepretrageDto.getAkcijaId());
			zonaPretrage.setId(zonepretrageDto.getId());
			zonaPretrage.setAkcijaspasavanje(akcija);
			zonaPretrage.setNaziv(zonepretrageDto.getNaziv());
			zonaPretrage.setLatitude(zonepretrageDto.getLatitude());
			zonaPretrage.setLongitude(zonepretrageDto.getLongitude());
			zonepretrageJpaRepository.delete(zonaPretrage);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
