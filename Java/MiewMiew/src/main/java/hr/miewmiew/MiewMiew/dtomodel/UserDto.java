package hr.miewmiew.MiewMiew.dtomodel;

import java.util.Date;

import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetusersEntity;

public class UserDto {
	
	private String id;
	
	private Integer accessfailedcount;
	
	private String concurrencystamp;
	
	private String email;
	
	private Boolean emailconfirmed;
	
	private Boolean lockoutenabled;
	
	private String lockoutend;
	
	private String normalizedemail;
	
	private String normalizedusername;
	
	private String passwordhash;
	
	private String phonenumber;
	
	private Boolean phonenumberconfirmed;
	
	private String securitystamp;
	
	private Boolean twofactorenabled;
	
	private String username;
	
	private String salt;
	
	private Date created;
	
	public UserDto() {
		super();
	}
	
	public UserDto(AspnetusersEntity aspnetusers) {
		super();
		this.id = aspnetusers.getId();
		this.accessfailedcount = aspnetusers.getAccessfailedcount();
		this.concurrencystamp = aspnetusers.getConcurrencystamp();
		this.email = aspnetusers.getEmail();
		this.emailconfirmed = aspnetusers.getEmailconfirmed();
		this.lockoutenabled = aspnetusers.getLockoutenabled();
		this.lockoutend = aspnetusers.getLockoutend();
		this.normalizedemail = aspnetusers.getNormalizedemail();
		this.normalizedusername = aspnetusers.getNormalizedusername();
		this.passwordhash = aspnetusers.getPasswordhash();
		this.phonenumber = aspnetusers.getPhonenumber();
		this.phonenumberconfirmed = aspnetusers.getPhonenumberconfirmed();
		this.securitystamp = aspnetusers.getSecuritystamp();
		this.twofactorenabled = aspnetusers.getTwofactorenabled();
		this.username = aspnetusers.getUsername();
		this.salt = aspnetusers.getSalt();
		this.created = aspnetusers.getCreated();
	}
	
	public UserDto(String id, Integer accessfailedcount, String concurrencystamp, String email, Boolean emailconfirmed,
			Boolean lockoutenabled, String lockoutend, String normalizedemail, String normalizedusername,
			String passwordhash, String phonenumber, Boolean phonenumberconfirmed, String securitystamp,
			Boolean twofactorenabled, String username, String salt, Date created) {
		super();
		this.id = id;
		this.accessfailedcount = accessfailedcount;
		this.concurrencystamp = concurrencystamp;
		this.email = email;
		this.emailconfirmed = emailconfirmed;
		this.lockoutenabled = lockoutenabled;
		this.lockoutend = lockoutend;
		this.normalizedemail = normalizedemail;
		this.normalizedusername = normalizedusername;
		this.passwordhash = passwordhash;
		this.phonenumber = phonenumber;
		this.phonenumberconfirmed = phonenumberconfirmed;
		this.securitystamp = securitystamp;
		this.twofactorenabled = twofactorenabled;
		this.username = username;
		this.salt = salt;
		this.created = created;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getAccessfailedcount() {
		return accessfailedcount;
	}
	
	public void setAccessfailedcount(Integer accessfailedcount) {
		this.accessfailedcount = accessfailedcount;
	}
	
	public String getConcurrencystamp() {
		return concurrencystamp;
	}
	
	public void setConcurrencystamp(String concurrencystamp) {
		this.concurrencystamp = concurrencystamp;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getEmailconfirmed() {
		return emailconfirmed;
	}
	
	public void setEmailconfirmed(Boolean emailconfirmed) {
		this.emailconfirmed = emailconfirmed;
	}
	
	public Boolean getLockoutenabled() {
		return lockoutenabled;
	}
	
	public void setLockoutenabled(Boolean lockoutenabled) {
		this.lockoutenabled = lockoutenabled;
	}
	
	public String getLockoutend() {
		return lockoutend;
	}
	
	public void setLockoutend(String lockoutend) {
		this.lockoutend = lockoutend;
	}
	
	public String getNormalizedemail() {
		return normalizedemail;
	}
	
	public void setNormalizedemail(String normalizedemail) {
		this.normalizedemail = normalizedemail;
	}
	
	public String getNormalizedusername() {
		return normalizedusername;
	}
	
	public void setNormalizedusername(String normalizedusername) {
		this.normalizedusername = normalizedusername;
	}
	
	public String getPasswordhash() {
		return passwordhash;
	}
	
	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public Boolean getPhonenumberconfirmed() {
		return phonenumberconfirmed;
	}
	
	public void setPhonenumberconfirmed(Boolean phonenumberconfirmed) {
		this.phonenumberconfirmed = phonenumberconfirmed;
	}
	
	public String getSecuritystamp() {
		return securitystamp;
	}
	
	public void setSecuritystamp(String securitystamp) {
		this.securitystamp = securitystamp;
	}
	
	public Boolean getTwofactorenabled() {
		return twofactorenabled;
	}
	
	public void setTwofactorenabled(Boolean twofactorenabled) {
		this.twofactorenabled = twofactorenabled;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
