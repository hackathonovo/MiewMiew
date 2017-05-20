package hr.miewmiew.MiewMiew.dtomodel;

import hr.miewmiew.MiewMiew.dbmodel.jpa.SpecijalnostiEntity;

public class SpecijalnostiEntityDto {
	private Integer id;
	
	private String naziv;
	
	// private List<SpecijalnostivrstaspasavanjaEntityDto>
	// listOfSpecijalnostivrstaspasavanja;
	
	// private List<VjestinekorisnikaEntityDto> listOfVjestinekorisnika;
	
	public SpecijalnostiEntityDto() {
		super();
	}
	
	public SpecijalnostiEntityDto(SpecijalnostiEntity s) {
		this.id = s.getId();
		this.naziv = s.getNaziv();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	// public List<SpecijalnostivrstaspasavanjaEntityDto>
	// getListOfSpecijalnostivrstaspasavanja() {
	// return listOfSpecijalnostivrstaspasavanja;
	// }
	//
	// public void setListOfSpecijalnostivrstaspasavanja(
	// List<SpecijalnostivrstaspasavanjaEntityDto>
	// listOfSpecijalnostivrstaspasavanja) {
	// this.listOfSpecijalnostivrstaspasavanja =
	// listOfSpecijalnostivrstaspasavanja;
	// }
	//
	// public List<VjestinekorisnikaEntityDto> getListOfVjestinekorisnika() {
	// return listOfVjestinekorisnika;
	// }
	//
	// public void setListOfVjestinekorisnika(List<VjestinekorisnikaEntityDto>
	// listOfVjestinekorisnika) {
	// this.listOfVjestinekorisnika = listOfVjestinekorisnika;
	// }
	
}
