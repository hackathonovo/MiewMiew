package hr.miewmiew.MiewMiew.dtomodel;

import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntity;

public class SudioniciUpdateAddDto {
	
	private String korisnikid;
	
	private Integer akcijaspasavanjaid;
	
	private Double latitude;
	
	private Double longitude;
	
	public SudioniciUpdateAddDto(String korisnikid, Integer akcijaspasavanjaid, Double latitude, Double longitude) {
		super();
		this.korisnikid = korisnikid;
		this.akcijaspasavanjaid = akcijaspasavanjaid;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public SudioniciUpdateAddDto() {
		super();
	}
	
	public SudioniciUpdateAddDto(SudioniciEntity sudionik) {
		this.korisnikid = sudionik.getKorisnikid();
		this.akcijaspasavanjaid = sudionik.getAkcijaspasavanjaid();
		this.latitude = sudionik.getLatitude();
		this.longitude = sudionik.getLongitude();
	}
	
	public String getKorisnikid() {
		return korisnikid;
	}
	
	public void setKorisnikid(String korisnikid) {
		this.korisnikid = korisnikid;
	}
	
	public Integer getAkcijaspasavanjaid() {
		return akcijaspasavanjaid;
	}
	
	public void setAkcijaspasavanjaid(Integer akcijaspasavanjaid) {
		this.akcijaspasavanjaid = akcijaspasavanjaid;
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
	
}
