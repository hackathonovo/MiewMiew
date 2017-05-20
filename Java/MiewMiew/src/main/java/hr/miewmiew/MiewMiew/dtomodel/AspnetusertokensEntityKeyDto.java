package hr.miewmiew.MiewMiew.dtomodel;

public class AspnetusertokensEntityKeyDto {
	private String userid;
	
	private String loginprovider;
	
	private String name;
	
	public AspnetusertokensEntityKeyDto() {
		super();
	}
	
	public AspnetusertokensEntityKeyDto(String userid, String loginprovider, String name) {
		super();
		this.userid = userid;
		this.loginprovider = loginprovider;
		this.name = name;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getLoginprovider() {
		return loginprovider;
	}
	
	public void setLoginprovider(String loginprovider) {
		this.loginprovider = loginprovider;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
