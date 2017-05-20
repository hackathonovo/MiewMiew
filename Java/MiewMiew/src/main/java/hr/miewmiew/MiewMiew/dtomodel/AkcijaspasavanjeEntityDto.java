package hr.miewmiew.MiewMiew.dtomodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hr.miewmiew.MiewMiew.dbmodel.jpa.AkcijaspasavanjeEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.PorukaEntity;

public class AkcijaspasavanjeEntityDto {
	
	private Integer id;
	
	private String naziv;
	
	private String opis;
	
	private Date vrijeme;
	
	private Byte potraga;
	
	private Integer fazazivotnogciklusa;
	
	private BigDecimal longitude;
	
	private BigDecimal latitude;
	
	private String nazivlokacije;
	
	private List<SudioniciEntityDto> listOfSudionici;
	
	private AspnetusersEntityDto aspnetusers;
	
	private VrstaspasavanjaEntityDto vrstaspasavanja;
	
	private List<PorukaEntityDto> listOfPoruka;
	
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
		AspnetusersEntityDto aspnetusersEntitiyDto = new AspnetusersEntityDto(a.getAspnetusers());
		this.aspnetusers = aspnetusersEntitiyDto;
		this.vrstaspasavanja = new VrstaspasavanjaEntityDto(a.getVrstaspasavanja());
		List<PorukaEntityDto> listaPoruka = new ArrayList<>();
		for (PorukaEntity p : a.getListOfPoruka()) {
			listaPoruka.add(new PorukaEntityDto(p));
		}
		this.listOfPoruka = listaPoruka;
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
	
	public BigDecimal getLongitude() {
		return longitude;
	}
	
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
	public BigDecimal getLatitude() {
		return latitude;
	}
	
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	
	public String getNazivlokacije() {
		return nazivlokacije;
	}
	
	public void setNazivlokacije(String nazivlokacije) {
		this.nazivlokacije = nazivlokacije;
	}
	
	public List<SudioniciEntityDto> getListOfSudionici() {
		return listOfSudionici;
	}
	
	public void setListOfSudionici(List<SudioniciEntityDto> listOfSudionici) {
		this.listOfSudionici = listOfSudionici;
	}
	
	public AspnetusersEntityDto getAspnetusers() {
		return aspnetusers;
	}
	
	public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
		this.aspnetusers = aspnetusers;
	}
	
	public VrstaspasavanjaEntityDto getVrstaspasavanja() {
		return vrstaspasavanja;
	}
	
	public void setVrstaspasavanja(VrstaspasavanjaEntityDto vrstaspasavanja) {
		this.vrstaspasavanja = vrstaspasavanja;
	}
	
	public List<PorukaEntityDto> getListOfPoruka() {
		return listOfPoruka;
	}
	
	public void setListOfPoruka(List<PorukaEntityDto> listOfPoruka) {
		this.listOfPoruka = listOfPoruka;
	}
	
}
