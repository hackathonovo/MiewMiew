package hr.miewmiew.MiewMiew.dtomodel;

import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetusersEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SpecijalnostiEntity;

public class VjestinekorisnikaEntityDto {
	private Integer id;
	
	private AspnetusersEntity aspnetusers;
	
	private SpecijalnostiEntity specijalnosti;
	
	public VjestinekorisnikaEntityDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public AspnetusersEntity getAspnetusers() {
		return aspnetusers;
	}
	
	public void setAspnetusers(AspnetusersEntity aspnetusers) {
		this.aspnetusers = aspnetusers;
	}
	
	public SpecijalnostiEntity getSpecijalnosti() {
		return specijalnosti;
	}
	
	public void setSpecijalnosti(SpecijalnostiEntity specijalnosti) {
		this.specijalnosti = specijalnosti;
	}
	
}
