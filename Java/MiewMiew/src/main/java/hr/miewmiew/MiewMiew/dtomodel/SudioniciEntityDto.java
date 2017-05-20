package hr.miewmiew.MiewMiew.dtomodel;

import java.math.BigDecimal;

public class SudioniciEntityDto {
	
	private SudioniciEntityKeyDto compositePrimaryKey;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	private AspnetusersEntityDto aspnetusers;
	
	private AkcijaspasavanjeEntityDto akcijaspasavanje;
	
	public SudioniciEntityDto() {
		super();
		this.compositePrimaryKey = new SudioniciEntityKeyDto();
	}
	
	public SudioniciEntityKeyDto getCompositePrimaryKey() {
		return compositePrimaryKey;
	}
	
	public void setCompositePrimaryKey(SudioniciEntityKeyDto compositePrimaryKey) {
		this.compositePrimaryKey = compositePrimaryKey;
	}
	
	public BigDecimal getLatitude() {
		return latitude;
	}
	
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	
	public BigDecimal getLongitude() {
		return longitude;
	}
	
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
	public AspnetusersEntityDto getAspnetusers() {
		return aspnetusers;
	}
	
	public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
		this.aspnetusers = aspnetusers;
	}
	
	public AkcijaspasavanjeEntityDto getAkcijaspasavanje() {
		return akcijaspasavanje;
	}
	
	public void setAkcijaspasavanje(AkcijaspasavanjeEntityDto akcijaspasavanje) {
		this.akcijaspasavanje = akcijaspasavanje;
	}
	
}
