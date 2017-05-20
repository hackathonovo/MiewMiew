package hr.miewmiew.MiewMiew.dtomodel;

public class SudioniciEntityKeyDto {
	private String korisnikid;
	
	private Integer akcijaspasavanjaid;
	
	public SudioniciEntityKeyDto() {
		super();
	}
	
	public SudioniciEntityKeyDto(String korisnikid, Integer akcijaspasavanjaid) {
		super();
		this.korisnikid = korisnikid;
		this.akcijaspasavanjaid = akcijaspasavanjaid;
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
	
}
