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

import hr.miewmiew.MiewMiew.data.repository.jpa.VrstaspasavanjaJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.VrstaspasavanjaEntity;
import hr.miewmiew.MiewMiew.dtomodel.VrstaspasavanjaEntityDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/vrstespasavanja")
public class VrstaspasavanjaController {
	
	@Autowired
	private VrstaspasavanjaJpaRepository vrstaspasavanjaJpaRepository;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<VrstaspasavanjaEntityDto>> getAll(HttpServletRequest request) {
		try {
			List<VrstaspasavanjaEntityDto> vrstaSpasavanjaDto = new ArrayList<>();
			List<VrstaspasavanjaEntity> vrsteSpasavanja = null;
			try {
				vrsteSpasavanja = vrstaspasavanjaJpaRepository.findAll();
			} catch (Exception e) {
				return new ResponseEntity<List<VrstaspasavanjaEntityDto>>(vrstaSpasavanjaDto, HttpStatus.OK);
			}
			
			for (VrstaspasavanjaEntity vs : vrsteSpasavanja) {
				vrstaSpasavanjaDto.add(new VrstaspasavanjaEntityDto(vs));
			}
			return new ResponseEntity<List<VrstaspasavanjaEntityDto>>(vrstaSpasavanjaDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ResponseEntity<VrstaspasavanjaEntityDto> update(HttpServletRequest request,
			@RequestBody VrstaspasavanjaEntityDto vrstaspasavanjaDto) {
		try {
			
			VrstaspasavanjaEntity vrstaSpasavanja = new VrstaspasavanjaEntity();
			vrstaSpasavanja.setId(vrstaspasavanjaDto.getId());
			vrstaSpasavanja.setVrsta(vrstaspasavanjaDto.getVrsta());
			VrstaspasavanjaEntity vrstaspasavanjaDtoReturned = vrstaspasavanjaJpaRepository.save(vrstaSpasavanja);
			
			return new ResponseEntity<VrstaspasavanjaEntityDto>(
					new VrstaspasavanjaEntityDto(vrstaspasavanjaDtoReturned), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/Add", method = RequestMethod.POST)
	public ResponseEntity<VrstaspasavanjaEntityDto> add(HttpServletRequest request,
			@RequestBody VrstaspasavanjaEntityDto vrstaspasavanjaDto) {
		try {
			
			VrstaspasavanjaEntity vrstaSpasavanja = new VrstaspasavanjaEntity();
			vrstaSpasavanja.setVrsta(vrstaspasavanjaDto.getVrsta());
			VrstaspasavanjaEntity vrstaspasavanjaDtoReturned = vrstaspasavanjaJpaRepository.save(vrstaSpasavanja);
			
			return new ResponseEntity<VrstaspasavanjaEntityDto>(
					new VrstaspasavanjaEntityDto(vrstaspasavanjaDtoReturned), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
