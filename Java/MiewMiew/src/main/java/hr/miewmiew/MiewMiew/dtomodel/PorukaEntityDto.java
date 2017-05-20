package hr.miewmiew.MiewMiew.dtomodel;

import java.util.Date;

import hr.miewmiew.MiewMiew.dbmodel.jpa.PorukaEntity;

public class PorukaEntityDto {
	private Integer id;
	
	private String poruka;
	
	private Date vrijeme;
	
	private Byte procitano;
	
	private AkcijaspasavanjeEntityDto akcijaspasavanje;
	
	private AspnetusersEntityDto aspnetusersSalje;
	
	private AspnetusersEntityDto aspnetusersPrima;
	
	public PorukaEntityDto() {
		super();
	}
	
	public PorukaEntityDto(PorukaEntity p) {
		this.id = p.getId();
		this.poruka = p.getPoruka();
		this.vrijeme = p.getVrijeme();
		this.procitano = p.getProcitano();
		this.aspnetusersPrima = new AspnetusersEntityDto(p.getAspnetusers());
		this.aspnetusersSalje = new AspnetusersEntityDto(p.getAspnetusers2());
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPoruka() {
		return poruka;
	}
	
	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}
	
	public Date getVrijeme() {
		return vrijeme;
	}
	
	public void setVrijeme(Date vrijeme) {
		this.vrijeme = vrijeme;
	}
	
	public Byte getProcitano() {
		return procitano;
	}
	
	public void setProcitano(Byte procitano) {
		this.procitano = procitano;
	}
	
	public AkcijaspasavanjeEntityDto getAkcijaspasavanje() {
		return akcijaspasavanje;
	}
	
	public void setAkcijaspasavanje(AkcijaspasavanjeEntityDto akcijaspasavanje) {
		this.akcijaspasavanje = akcijaspasavanje;
	}
	
	public AspnetusersEntityDto getAspnetusersSalje() {
		return aspnetusersSalje;
	}
	
	public void setAspnetusersSalje(AspnetusersEntityDto aspnetusersSalje) {
		this.aspnetusersSalje = aspnetusersSalje;
	}
	
	public AspnetusersEntityDto getAspnetusers2() {
		return aspnetusersPrima;
	}
	
	public void setAspnetusersPrima(AspnetusersEntityDto aspnetusersPrima) {
		this.aspnetusersPrima = aspnetusersPrima;
	}
	
}
