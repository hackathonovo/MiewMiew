package hr.miewmiew.MiewMiew.dtomodel;

public class AspnetuserrolesEntityKeyDto {
	
	private String userid;
	
	private String roleid;
	
	public AspnetuserrolesEntityKeyDto() {
		super();
	}
	
	public AspnetuserrolesEntityKeyDto(String userid, String roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getRoleid() {
		return roleid;
	}
	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
}
