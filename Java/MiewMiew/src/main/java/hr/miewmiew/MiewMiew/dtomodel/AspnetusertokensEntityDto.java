package hr.miewmiew.MiewMiew.dtomodel;

public class AspnetusertokensEntityDto {
	private AspnetusertokensEntityKeyDto compositePrimaryKey;
	
	private String value;
	
	public AspnetusertokensEntityDto() {
		super();
		this.compositePrimaryKey = new AspnetusertokensEntityKeyDto();
	}
	
	public AspnetusertokensEntityKeyDto getCompositePrimaryKey() {
		return compositePrimaryKey;
	}
	
	public void setCompositePrimaryKey(AspnetusertokensEntityKeyDto compositePrimaryKey) {
		this.compositePrimaryKey = compositePrimaryKey;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}
