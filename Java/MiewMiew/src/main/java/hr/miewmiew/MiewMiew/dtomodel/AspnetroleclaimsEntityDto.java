package hr.miewmiew.MiewMiew.dtomodel;

public class AspnetroleclaimsEntityDto {
	
	private Integer id;
	
	private String claimtype;
	
	private String claimvalue;
	
	private AspnetrolesEntityDto aspnetroles;
	
	public AspnetroleclaimsEntityDto() {
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
	
	public AspnetrolesEntityDto getAspnetroles() {
		return aspnetroles;
	}
	
	public void setAspnetroles(AspnetrolesEntityDto aspnetroles) {
		this.aspnetroles = aspnetroles;
	}
	
}
