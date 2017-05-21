package hr.miewmiew.MiewMiew.dtomodel;

import hr.miewmiew.MiewMiew.dbmodel.jpa.SpecijalnostivrstaspasavanjaEntity;

public class SpecijalnostiVrstaIdOnly {
	private Integer specijalnostId;
	private Integer vrstaId;
	
	public SpecijalnostiVrstaIdOnly() {
		super();
	}
	
	public SpecijalnostiVrstaIdOnly(SpecijalnostivrstaspasavanjaEntity s) {
		super();
		this.specijalnostId = s.getSpecijalnosti().getId();
		this.vrstaId = s.getVrstaspasavanja().getId();
	}
	
	public Integer getSpecijalnostId() {
		return specijalnostId;
	}
	
	public void setSpecijalnostId(Integer specijalnostId) {
		this.specijalnostId = specijalnostId;
	}
	
	public Integer getVrstaId() {
		return vrstaId;
	}
	
	public void setVrstaId(Integer vrstaId) {
		this.vrstaId = vrstaId;
	}
	
}
