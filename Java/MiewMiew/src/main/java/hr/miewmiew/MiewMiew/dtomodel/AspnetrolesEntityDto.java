package hr.miewmiew.MiewMiew.dtomodel;

import java.util.List;

public class AspnetrolesEntityDto {
	
	private String id;
	
	private String concurrencystamp;
	
	private String name;
	
	private String normalizedname;
	
	private List<AspnetroleclaimsEntityDto> listOfAspnetroleclaims;
	
	private List<AspnetusersEntityDto> listOfAspnetusers;
	
	public AspnetrolesEntityDto() {
		super();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getConcurrencystamp() {
		return concurrencystamp;
	}
	
	public void setConcurrencystamp(String concurrencystamp) {
		this.concurrencystamp = concurrencystamp;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNormalizedname() {
		return normalizedname;
	}
	
	public void setNormalizedname(String normalizedname) {
		this.normalizedname = normalizedname;
	}
	
	public List<AspnetroleclaimsEntityDto> getListOfAspnetroleclaims() {
		return listOfAspnetroleclaims;
	}
	
	public void setListOfAspnetroleclaims(List<AspnetroleclaimsEntityDto> listOfAspnetroleclaims) {
		this.listOfAspnetroleclaims = listOfAspnetroleclaims;
	}
	
	public List<AspnetusersEntityDto> getListOfAspnetusers() {
		return listOfAspnetusers;
	}
	
	public void setListOfAspnetusers(List<AspnetusersEntityDto> listOfAspnetusers) {
		this.listOfAspnetusers = listOfAspnetusers;
	}
	
}
