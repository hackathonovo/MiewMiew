package hr.miewmiew.MiewMiew.dtomodel;

import hr.miewmiew.MiewMiew.dbmodel.jpa.VrstaspasavanjaEntity;

public class VrstaspasavanjaEntityDto {
	private Integer id;
	
	private String vrsta;
	
	// private List<SpecijalnostivrstaspasavanjaEntityDto>
	// listOfSpecijalnostivrstaspasavanja;
	
	// private List<AkcijaspasavanjeEntityDto> listOfAkcijaspasavanje;
	
	public VrstaspasavanjaEntityDto() {
		super();
	}
	
	public VrstaspasavanjaEntityDto(VrstaspasavanjaEntity vrstaspasavanja) {
		this.id = vrstaspasavanja.getId();
		this.vrsta = vrstaspasavanja.getVrsta();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getVrsta() {
		return vrsta;
	}
	
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
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
	// public List<AkcijaspasavanjeEntityDto> getListOfAkcijaspasavanje() {
	// return listOfAkcijaspasavanje;
	// }
	//
	// public void setListOfAkcijaspasavanje(List<AkcijaspasavanjeEntityDto>
	// listOfAkcijaspasavanje) {
	// this.listOfAkcijaspasavanje = listOfAkcijaspasavanje;
	// }
	
}
