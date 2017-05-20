package hr.miewmiew.MiewMiew.dtomodel;

public class SocketconnectionEntityDto {
	private Integer id;
	
	private String socketid;
	
	private AspnetusersEntityDto aspnetusers;
	
	public SocketconnectionEntityDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSocketid() {
		return socketid;
	}
	
	public void setSocketid(String socketid) {
		this.socketid = socketid;
	}
	
	public AspnetusersEntityDto getAspnetusers() {
		return aspnetusers;
	}
	
	public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
		this.aspnetusers = aspnetusers;
	}
	
}
