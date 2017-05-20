package hr.miewmiew.MiewMiew.dtomodel;

public class SocketEntityDto {
	private Integer id;
	
	private String message;
	
	private AspnetusersEntityDto aspnetusers;
	
	public SocketEntityDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public AspnetusersEntityDto getAspnetusers() {
		return aspnetusers;
	}
	
	public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
		this.aspnetusers = aspnetusers;
	}
	
}
