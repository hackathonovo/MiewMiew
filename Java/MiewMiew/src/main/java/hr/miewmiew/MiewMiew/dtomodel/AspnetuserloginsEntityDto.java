package hr.miewmiew.MiewMiew.dtomodel;

public class AspnetuserloginsEntityDto {
	
	private AspnetuserloginsEntityKeyDto compositePrimaryKey;
	
	private String providerdisplayname;
	
	private AspnetusersEntityDto aspnetusers;
	
	public AspnetuserloginsEntityDto() {
		super();
	}
	
	public AspnetuserloginsEntityKeyDto getCompositePrimaryKey() {
		return compositePrimaryKey;
	}
	
	public void setCompositePrimaryKey(AspnetuserloginsEntityKeyDto compositePrimaryKey) {
		this.compositePrimaryKey = compositePrimaryKey;
	}
	
	public String getProviderdisplayname() {
		return providerdisplayname;
	}
	
	public void setProviderdisplayname(String providerdisplayname) {
		this.providerdisplayname = providerdisplayname;
	}
	
	public AspnetusersEntityDto getAspnetusers() {
		return aspnetusers;
	}
	
	public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
		this.aspnetusers = aspnetusers;
	}
	
}
