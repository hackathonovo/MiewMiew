package hr.miewmiew.MiewMiew.dtomodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetusersEntity;

public class AspnetusersEntityDto {
	
	private String id;
	
	// private Integer accessfailedcount;
	
	// private String concurrencystamp;
	
	private String email;
	
	// private Boolean emailconfirmed;
	
	// private Boolean lockoutenabled;
	
	// private String lockoutend;
	
	// private String normalizedemail;
	
	// private String normalizedusername;
	
	// private String passwordhash;
	
	private String phonenumber;
	
	// private Boolean phonenumberconfirmed;
	
	// private String securitystamp;
	
	// private Boolean twofactorenabled;
	
	private String username;
	
	// private String salt;
	
	private Date created;
	
	private String ime;
	
	private String prezime;
	
	private Integer razina;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	// private List<AkcijaspasavanjeEntityDto> listOfAkcijaspasavanje;
	
	// private List<DostupanEntityDto> listOfDostupan;
	
	// private List<SudioniciEntityDto> listOfSudionici;
	
	// private List<NedostupanEntityDto> listOfNedostupan;
	
	// private List<PorukaEntityDto> listOfPoruka;
	
	// private List<AspnetuserclaimsEntityDto> listOfAspnetuserclaims;
	
	// private List<AspnetrolesEntityDto> listOfAspnetroles;
	
	// private List<PorukaEntityDto> listOfPoruka2;
	
	private List<VjestinekorisnikaEntityDto> listOfVjestinekorisnika;
	
	// private List<SocketconnectionEntityDto> listOfSocketconnection;
	
	// private List<AspnetuserloginsEntityDto> listOfAspnetuserlogins;
	
	// private List<SocketEntityDto> listOfSocket;
	
	public AspnetusersEntityDto() {
		super();
	}
	
	public AspnetusersEntityDto(AspnetusersEntity aspnetusers) {
		this.id = aspnetusers.getId();
		this.email = aspnetusers.getEmail();
		this.phonenumber = aspnetusers.getPhonenumber();
		this.username = aspnetusers.getUsername();
		this.created = aspnetusers.getCreated();
		this.ime = aspnetusers.getIme();
		this.prezime = aspnetusers.getPrezime();
		this.razina = aspnetusers.getRazina();
		this.latitude = aspnetusers.getLatitude();
		this.longitude = aspnetusers.getLongitude();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	// public Integer getAccessfailedcount() {
	// return accessfailedcount;
	// }
	//
	// public void setAccessfailedcount(Integer accessfailedcount) {
	// this.accessfailedcount = accessfailedcount;
	// }
	//
	// public String getConcurrencystamp() {
	// return concurrencystamp;
	// }
	//
	// public void setConcurrencystamp(String concurrencystamp) {
	// this.concurrencystamp = concurrencystamp;
	// }
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// public Boolean getEmailconfirmed() {
	// return emailconfirmed;
	// }
	//
	// public void setEmailconfirmed(Boolean emailconfirmed) {
	// this.emailconfirmed = emailconfirmed;
	// }
	//
	// public Boolean getLockoutenabled() {
	// return lockoutenabled;
	// }
	//
	// public void setLockoutenabled(Boolean lockoutenabled) {
	// this.lockoutenabled = lockoutenabled;
	// }
	//
	// public String getLockoutend() {
	// return lockoutend;
	// }
	//
	// public void setLockoutend(String lockoutend) {
	// this.lockoutend = lockoutend;
	// }
	//
	// public String getNormalizedemail() {
	// return normalizedemail;
	// }
	//
	// public void setNormalizedemail(String normalizedemail) {
	// this.normalizedemail = normalizedemail;
	// }
	//
	// public String getNormalizedusername() {
	// return normalizedusername;
	// }
	//
	// public void setNormalizedusername(String normalizedusername) {
	// this.normalizedusername = normalizedusername;
	// }
	//
	// public String getPasswordhash() {
	// return passwordhash;
	// }
	//
	// public void setPasswordhash(String passwordhash) {
	// this.passwordhash = passwordhash;
	// }
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	// public Boolean getPhonenumberconfirmed() {
	// return phonenumberconfirmed;
	// }
	//
	// public void setPhonenumberconfirmed(Boolean phonenumberconfirmed) {
	// this.phonenumberconfirmed = phonenumberconfirmed;
	// }
	//
	// public String getSecuritystamp() {
	// return securitystamp;
	// }
	//
	// public void setSecuritystamp(String securitystamp) {
	// this.securitystamp = securitystamp;
	// }
	//
	// public Boolean getTwofactorenabled() {
	// return twofactorenabled;
	// }
	//
	// public void setTwofactorenabled(Boolean twofactorenabled) {
	// this.twofactorenabled = twofactorenabled;
	// }
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	// public String getSalt() {
	// return salt;
	// }
	//
	// public void setSalt(String salt) {
	// this.salt = salt;
	// }
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public Integer getRazina() {
		return razina;
	}
	
	public void setRazina(Integer razina) {
		this.razina = razina;
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
	
	// public List<AkcijaspasavanjeEntityDto> getListOfAkcijaspasavanje() {
	// return listOfAkcijaspasavanje;
	// }
	//
	// public void setListOfAkcijaspasavanje(List<AkcijaspasavanjeEntityDto>
	// listOfAkcijaspasavanje) {
	// this.listOfAkcijaspasavanje = listOfAkcijaspasavanje;
	// }
	//
	// public List<DostupanEntityDto> getListOfDostupan() {
	// return listOfDostupan;
	// }
	//
	// public void setListOfDostupan(List<DostupanEntityDto> listOfDostupan) {
	// this.listOfDostupan = listOfDostupan;
	// }
	//
	// public List<SudioniciEntityDto> getListOfSudionici() {
	// return listOfSudionici;
	// }
	//
	// public void setListOfSudionici(List<SudioniciEntityDto> listOfSudionici)
	// {
	// this.listOfSudionici = listOfSudionici;
	// }
	//
	// public List<NedostupanEntityDto> getListOfNedostupan() {
	// return listOfNedostupan;
	// }
	//
	// public void setListOfNedostupan(List<NedostupanEntityDto>
	// listOfNedostupan) {
	// this.listOfNedostupan = listOfNedostupan;
	// }
	
	// public List<PorukaEntityDto> getListOfPoruka() {
	// return listOfPoruka;
	// }
	//
	// public void setListOfPoruka(List<PorukaEntityDto> listOfPoruka) {
	// this.listOfPoruka = listOfPoruka;
	// }
	//
	// public List<AspnetuserclaimsEntityDto> getListOfAspnetuserclaims() {
	// return listOfAspnetuserclaims;
	// }
	//
	// public void setListOfAspnetuserclaims(List<AspnetuserclaimsEntityDto>
	// listOfAspnetuserclaims) {
	// this.listOfAspnetuserclaims = listOfAspnetuserclaims;
	// }
	//
	// public List<AspnetrolesEntityDto> getListOfAspnetroles() {
	// return listOfAspnetroles;
	// }
	//
	// public void setListOfAspnetroles(List<AspnetrolesEntityDto>
	// listOfAspnetroles) {
	// this.listOfAspnetroles = listOfAspnetroles;
	// }
	//
	// public List<PorukaEntityDto> getListOfPoruka2() {
	// return listOfPoruka2;
	// }
	//
	// public void setListOfPoruka2(List<PorukaEntityDto> listOfPoruka2) {
	// this.listOfPoruka2 = listOfPoruka2;
	// }
	
	public List<VjestinekorisnikaEntityDto> getListOfVjestinekorisnika() {
		return listOfVjestinekorisnika;
	}
	
	public void setListOfVjestinekorisnika(List<VjestinekorisnikaEntityDto> listOfVjestinekorisnika) {
		this.listOfVjestinekorisnika = listOfVjestinekorisnika;
	}
	
	// public List<SocketconnectionEntityDto> getListOfSocketconnection() {
	// return listOfSocketconnection;
	// }
	//
	// public void setListOfSocketconnection(List<SocketconnectionEntityDto>
	// listOfSocketconnection) {
	// this.listOfSocketconnection = listOfSocketconnection;
	// }
	//
	// public List<AspnetuserloginsEntityDto> getListOfAspnetuserlogins() {
	// return listOfAspnetuserlogins;
	// }
	//
	// public void setListOfAspnetuserlogins(List<AspnetuserloginsEntityDto>
	// listOfAspnetuserlogins) {
	// this.listOfAspnetuserlogins = listOfAspnetuserlogins;
	// }
	//
	// public List<SocketEntityDto> getListOfSocket() {
	// return listOfSocket;
	// }
	//
	// public void setListOfSocket(List<SocketEntityDto> listOfSocket) {
	// this.listOfSocket = listOfSocket;
	// }
	
}
