package hr.miewmiew.MiewMiew.dtomodel;

public class SudioniciCustomDto {
	private String userName;
	private String ime;
	private String prezime;
	private Double latitude;
	private Double longitude;
	private Boolean prihvatio;
	
	public SudioniciCustomDto() {
		super();
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Boolean getPrihvatio() {
		return prihvatio;
	}
	
	public void setPrihvatio(Boolean prihvatio) {
		this.prihvatio = prihvatio;
	}
	
}
