package hr.miewmiew.MiewMiew.dtomodel;

import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntity;

public class SudioniciEntityDto {
	
	private SudioniciEntityKeyDto compositePrimaryKey;
	
	private Double latitude;
	
	private Double longitude;
	
	private Boolean prihvatio;
	
	// private AspnetusersEntityDto aspnetusers;
	
	// private AkcijaspasavanjeEntityDto akcijaspasavanje;
	
	public SudioniciEntityDto() {
		super();
		this.compositePrimaryKey = new SudioniciEntityKeyDto();
	}
	
	public SudioniciEntityDto(SudioniciEntity sudionikReturned) {
		this.compositePrimaryKey = new SudioniciEntityKeyDto(sudionikReturned.getKorisnikid(),
				sudionikReturned.getAkcijaspasavanjaid());
		this.latitude = sudionikReturned.getLatitude();
		this.longitude = sudionikReturned.getLongitude();
		this.prihvatio = sudionikReturned.getPrihvatio();
	}
	
	public SudioniciEntityKeyDto getCompositePrimaryKey() {
		return compositePrimaryKey;
	}
	
	public void setCompositePrimaryKey(SudioniciEntityKeyDto compositePrimaryKey) {
		this.compositePrimaryKey = compositePrimaryKey;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Boolean getPrihvatio() {
		return prihvatio;
	}
	
	public void setPrihvatio(Boolean prihvatio) {
		this.prihvatio = prihvatio;
	}
	
	// public AspnetusersEntityDto getAspnetusers() {
	// return aspnetusers;
	// }
	//
	// public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
	// this.aspnetusers = aspnetusers;
	// }
	//
	// public AkcijaspasavanjeEntityDto getAkcijaspasavanje() {
	// return akcijaspasavanje;
	// }
	//
	// public void setAkcijaspasavanje(AkcijaspasavanjeEntityDto
	// akcijaspasavanje) {
	// this.akcijaspasavanje = akcijaspasavanje;
	// }
	
}
