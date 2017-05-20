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

import hr.miewmiew.MiewMiew.data.repository.jpa.VrstaspasavanjaJpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.VrstaspasavanjaEntity;
import hr.miewmiew.MiewMiew.dtomodel.VrstaspasavanjaEntityDto;

@RestController
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
}
