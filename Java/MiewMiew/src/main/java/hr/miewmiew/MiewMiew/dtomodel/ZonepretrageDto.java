package hr.miewmiew.MiewMiew.dtomodel;

import hr.miewmiew.MiewMiew.dbmodel.jpa.ZonepretrageEntity;

public class ZonepretrageDto {
	private Integer id;
	
	private String naziv;
	
	private Double latitude;
	
	private Double longitude;
	
	private Integer akcijaId;
	
	public ZonepretrageDto() {
		super();
	}
	
	public ZonepretrageDto(ZonepretrageEntity z) {
		this.id = z.getId();
		this.naziv = z.getNaziv();
		this.latitude = z.getLatitude();
		this.longitude = z.getLongitude();
		this.akcijaId = z.getAkcijaspasavanje().getId();
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
	
	public Integer getAkcijaId() {
		return akcijaId;
	}
	
	public void setAkcijaId(Integer akcijaSpasavanjaId) {
		this.akcijaId = akcijaSpasavanjaId;
	}
	
}
