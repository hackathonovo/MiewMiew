package hr.miewmiew.MiewMiew.dtomodel;

public class KompetencijekorisnikaEntityDto {
	private Integer id;
	
	private String korisnik;
	
	private Integer kompetencija;
	
	public KompetencijekorisnikaEntityDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getKorisnik() {
		return korisnik;
	}
	
	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}
	
	public Integer getKompetencija() {
		return kompetencija;
	}
	
	public void setKompetencija(Integer kompetencija) {
		this.kompetencija = kompetencija;
	}
	
}
