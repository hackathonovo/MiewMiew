package hr.miewmiew.MiewMiew.dtomodel;

public class AspnetuserclaimsEntityDto {
	
	private Integer id;
	
	private String claimtype;
	
	private String claimvalue;
	
	private AspnetusersEntityDto aspnetusers;
	
	public AspnetuserclaimsEntityDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getClaimtype() {
		return claimtype;
	}
	
	public void setClaimtype(String claimtype) {
		this.claimtype = claimtype;
	}
	
	public String getClaimvalue() {
		return claimvalue;
	}
	
	public void setClaimvalue(String claimvalue) {
		this.claimvalue = claimvalue;
	}
	
	public AspnetusersEntityDto getAspnetusers() {
		return aspnetusers;
	}
	
	public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
		this.aspnetusers = aspnetusers;
	}
	
}
