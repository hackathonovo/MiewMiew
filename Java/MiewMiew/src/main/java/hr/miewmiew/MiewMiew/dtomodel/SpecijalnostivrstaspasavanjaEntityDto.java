package hr.miewmiew.MiewMiew.dtomodel;

public class SpecijalnostivrstaspasavanjaEntityDto {
	private Integer id;
	
	private SpecijalnostiEntityDto specijalnosti;
	
	private VrstaspasavanjaEntityDto vrstaspasavanja;
	
	public SpecijalnostivrstaspasavanjaEntityDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public SpecijalnostiEntityDto getSpecijalnosti() {
		return specijalnosti;
	}
	
	public void setSpecijalnosti(SpecijalnostiEntityDto specijalnosti) {
		this.specijalnosti = specijalnosti;
	}
	
	public VrstaspasavanjaEntityDto getVrstaspasavanja() {
		return vrstaspasavanja;
	}
	
	public void setVrstaspasavanja(VrstaspasavanjaEntityDto vrstaspasavanja) {
		this.vrstaspasavanja = vrstaspasavanja;
	}
	
}
