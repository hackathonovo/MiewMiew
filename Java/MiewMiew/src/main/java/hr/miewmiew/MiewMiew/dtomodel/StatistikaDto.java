package hr.miewmiew.MiewMiew.dtomodel;

import java.util.Date;

public class StatistikaDto {
	private int id;
	private String nazivAkcije;
	private String voditelj;
	private int brojSudionika;
	private String vrstaSpasavanjaNaziv;
	private String status;
	private String nazivLokacije;
	private Date vrijemeAkcije;
	
	public StatistikaDto() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNazivAkcije() {
		return nazivAkcije;
	}
	
	public void setNazivAkcije(String nazivAkcije) {
		this.nazivAkcije = nazivAkcije;
	}
	
	public int getBrojSudionika() {
		return brojSudionika;
	}
	
	public void setBrojSudionika(int brojSudionika) {
		this.brojSudionika = brojSudionika;
	}
	
	public String getVrstaSpasavanjaNaziv() {
		return vrstaSpasavanjaNaziv;
	}
	
	public void setVrstaSpasavanjaNaziv(String vrstaSpasavanjaNaziv) {
		this.vrstaSpasavanjaNaziv = vrstaSpasavanjaNaziv;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNazivLokacije() {
		return nazivLokacije;
	}
	
	public void setNazivLokacije(String nazivLokacije) {
		this.nazivLokacije = nazivLokacije;
	}
	
	public Date getVrijemeAkcije() {
		return vrijemeAkcije;
	}
	
	public void setVrijemeAkcije(Date vrijemeAkcije) {
		this.vrijemeAkcije = vrijemeAkcije;
	}
	
	public String getVoditelj() {
		return voditelj;
	}
	
	public void setVoditelj(String voditelj) {
		this.voditelj = voditelj;
	}
	
}
