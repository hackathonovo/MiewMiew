package hr.miewmiew.MiewMiew.dtomodel;

import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntity;

public class SudioniciUpdateAddDto {
	
	private String korisnikid;
	
	private Integer akcijaspasavanjaid;
	
	private Double latitude;
	
	private Double longitude;
	
	private Boolean prihvatio;
	
	public SudioniciUpdateAddDto(String korisnikid, Integer akcijaspasavanjaid, Double latitude, Double longitude,
			Boolean prihvatio) {
		super();
		this.korisnikid = korisnikid;
		this.akcijaspasavanjaid = akcijaspasavanjaid;
		this.latitude = latitude;
		this.longitude = longitude;
		this.prihvatio = prihvatio;
	}
	
	public SudioniciUpdateAddDto() {
		super();
	}
	
	public SudioniciUpdateAddDto(SudioniciEntity sudionik) {
		this.korisnikid = sudionik.getKorisnikid();
		this.akcijaspasavanjaid = sudionik.getAkcijaspasavanjaid();
		this.latitude = sudionik.getLatitude();
		this.longitude = sudionik.getLongitude();
		this.prihvatio = sudionik.getPrihvatio();
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
	
	public Boolean getPrihvatio() {
		return prihvatio;
	}
	
	public void setPrihvatio(Boolean prihvatio) {
		this.prihvatio = prihvatio;
	}
	
}
