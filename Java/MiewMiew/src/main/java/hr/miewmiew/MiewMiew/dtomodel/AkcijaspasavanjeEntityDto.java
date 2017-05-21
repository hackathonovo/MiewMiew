package hr.miewmiew.MiewMiew.dtomodel;

import java.util.Date;

import hr.miewmiew.MiewMiew.dbmodel.jpa.AkcijaspasavanjeEntity;

public class AkcijaspasavanjeEntityDto {
	
	private Integer id;
	
	private String naziv;
	
	private String opis;
	
	private Date vrijeme;
	
	private Byte potraga;
	
	private Integer fazazivotnogciklusa;
	
	private Double longitude;
	
	private Double latitude;
	
	private Double radius;
	
	private String nazivlokacije;
	
	// private List<SudioniciEntityDto> listOfSudionici;
	
	private String voditeljId;
	
	private Integer vrstaspasavanjaId;
	
	// private List<PorukaEntityDto> listOfPoruka;
	
	public AkcijaspasavanjeEntityDto() {
		super();
	}
	
	public AkcijaspasavanjeEntityDto(AkcijaspasavanjeEntity a) {
		this.id = a.getId();
		this.naziv = a.getNaziv();
		this.opis = a.getOpis();
		this.vrijeme = a.getVrijeme();
		this.potraga = a.getPotraga();
		this.fazazivotnogciklusa = a.getFazazivotnogciklusa();
		this.longitude = a.getLongitude();
		this.latitude = a.getLatitude();
		this.nazivlokacije = a.getNazivlokacije();
		this.voditeljId = a.getAspnetusers().getId();
		this.vrstaspasavanjaId = a.getVrstaspasavanja().getId();
		
		// AspnetusersEntityDto aspnetusersEntitiyDto = new
		// AspnetusersEntityDto(a.getAspnetusers());
		// this.aspnetusers = aspnetusersEntitiyDto;
		// this.vrstaspasavanja = new
		// VrstaspasavanjaEntityDto(a.getVrstaspasavanja());
		// List<PorukaEntityDto> listaPoruka = new ArrayList<>();
		// for (PorukaEntity p : a.getListOfPoruka()) {
		// listaPoruka.add(new PorukaEntityDto(p));
		// }
		// this.listOfPoruka = listaPoruka;
		this.radius = a.getRadius();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public Date getVrijeme() {
		return vrijeme;
	}
	
	public void setVrijeme(Date vrijeme) {
		this.vrijeme = vrijeme;
	}
	
	public Byte getPotraga() {
		return potraga;
	}
	
	public void setPotraga(Byte potraga) {
		this.potraga = potraga;
	}
	
	public Integer getFazazivotnogciklusa() {
		return fazazivotnogciklusa;
	}
	
	public void setFazazivotnogciklusa(Integer fazazivotnogciklusa) {
		this.fazazivotnogciklusa = fazazivotnogciklusa;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public String getNazivlokacije() {
		return nazivlokacije;
	}
	
	public void setNazivlokacije(String nazivlokacije) {
		this.nazivlokacije = nazivlokacije;
	}
	
	// public List<SudioniciEntityDto> getListOfSudionici() {
	// return listOfSudionici;
	// }
	//
	// public void setListOfSudionici(List<SudioniciEntityDto> listOfSudionici)
	// {
	// this.listOfSudionici = listOfSudionici;
	// }
	//
	// public AspnetusersEntityDto getAspnetusers() {
	// return aspnetusers;
	// }
	//
	// public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
	// this.aspnetusers = aspnetusers;
	// }
	//
	// public VrstaspasavanjaEntityDto getVrstaspasavanja() {
	// return vrstaspasavanja;
	// }
	//
	// public void setVrstaspasavanja(VrstaspasavanjaEntityDto vrstaspasavanja)
	// {
	// this.vrstaspasavanja = vrstaspasavanja;
	// }
	//
	// public List<PorukaEntityDto> getListOfPoruka() {
	// return listOfPoruka;
	// }
	//
	// public void setListOfPoruka(List<PorukaEntityDto> listOfPoruka) {
	// this.listOfPoruka = listOfPoruka;
	// }
	
	public Double getRadius() {
		return radius;
	}
	
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	public String getVoditeljId() {
		return voditeljId;
	}
	
	public void setVoditeljId(String voditeljId) {
		this.voditeljId = voditeljId;
	}
	
	public Integer getVrstaspasavanjaId() {
		return vrstaspasavanjaId;
	}
	
	public void setVrstaspasavanjaId(Integer vrstaspasavanjaId) {
		this.vrstaspasavanjaId = vrstaspasavanjaId;
	}
	
}
