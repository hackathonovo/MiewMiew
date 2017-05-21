/*
 * Created on 21 svi 2017 ( Time 01:10:02 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package hr.miewmiew.MiewMiew.dbmodel.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "AkcijaSpasavanje"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="AkcijaSpasavanje", schema="dbo", catalog="HackatonIn2" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AkcijaspasavanjeEntity.countAll", query="SELECT COUNT(x) FROM AkcijaspasavanjeEntity x" )
} )
public class AkcijaspasavanjeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="Naziv")
    private String     naziv        ;

    @Column(name="Opis")
    private String     opis         ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Vrijeme")
    private Date       vrijeme      ;

    @Column(name="Potraga")
    private Byte       potraga      ;

    @Column(name="FazaZivotnogCiklusa")
    private Integer    fazazivotnogciklusa ;

    @Column(name="Longitude")
    private Double     longitude    ;

    @Column(name="Latitude")
    private Double     latitude     ;

    @Column(name="NazivLokacije")
    private String     nazivlokacije ;

    @Column(name="Radius")
    private Double     radius       ;

	// "voditeljid" (column "VoditeljId") is not defined by itself because used as FK in a link 
	// "vrstaspasavanjaid" (column "VrstaSpasavanjaId") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="akcijaspasavanje", targetEntity=SudioniciEntity.class)
    private List<SudioniciEntity> listOfSudionici;

    @OneToMany(mappedBy="akcijaspasavanje", targetEntity=ZonepretrageEntity.class)
    private List<ZonepretrageEntity> listOfZonepretrage;

    @ManyToOne
    @JoinColumn(name="VoditeljId", referencedColumnName="Id")
    private AspnetusersEntity aspnetusers ;

    @ManyToOne
    @JoinColumn(name="VrstaSpasavanjaId", referencedColumnName="id")
    private VrstaspasavanjaEntity vrstaspasavanja;

    @OneToMany(mappedBy="akcijaspasavanje", targetEntity=PorukaEntity.class)
    private List<PorukaEntity> listOfPoruka;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AkcijaspasavanjeEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : Naziv ( nvarchar ) 
    public void setNaziv( String naziv ) {
        this.naziv = naziv;
    }
    public String getNaziv() {
        return this.naziv;
    }

    //--- DATABASE MAPPING : Opis ( nvarchar ) 
    public void setOpis( String opis ) {
        this.opis = opis;
    }
    public String getOpis() {
        return this.opis;
    }

    //--- DATABASE MAPPING : Vrijeme ( datetime ) 
    public void setVrijeme( Date vrijeme ) {
        this.vrijeme = vrijeme;
    }
    public Date getVrijeme() {
        return this.vrijeme;
    }

    //--- DATABASE MAPPING : Potraga ( tinyint ) 
    public void setPotraga( Byte potraga ) {
        this.potraga = potraga;
    }
    public Byte getPotraga() {
        return this.potraga;
    }

    //--- DATABASE MAPPING : FazaZivotnogCiklusa ( int ) 
    public void setFazazivotnogciklusa( Integer fazazivotnogciklusa ) {
        this.fazazivotnogciklusa = fazazivotnogciklusa;
    }
    public Integer getFazazivotnogciklusa() {
        return this.fazazivotnogciklusa;
    }

    //--- DATABASE MAPPING : Longitude ( float ) 
    public void setLongitude( Double longitude ) {
        this.longitude = longitude;
    }
    public Double getLongitude() {
        return this.longitude;
    }

    //--- DATABASE MAPPING : Latitude ( float ) 
    public void setLatitude( Double latitude ) {
        this.latitude = latitude;
    }
    public Double getLatitude() {
        return this.latitude;
    }

    //--- DATABASE MAPPING : NazivLokacije ( nvarchar ) 
    public void setNazivlokacije( String nazivlokacije ) {
        this.nazivlokacije = nazivlokacije;
    }
    public String getNazivlokacije() {
        return this.nazivlokacije;
    }

    //--- DATABASE MAPPING : Radius ( float ) 
    public void setRadius( Double radius ) {
        this.radius = radius;
    }
    public Double getRadius() {
        return this.radius;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfSudionici( List<SudioniciEntity> listOfSudionici ) {
        this.listOfSudionici = listOfSudionici;
    }
    public List<SudioniciEntity> getListOfSudionici() {
        return this.listOfSudionici;
    }

    public void setListOfZonepretrage( List<ZonepretrageEntity> listOfZonepretrage ) {
        this.listOfZonepretrage = listOfZonepretrage;
    }
    public List<ZonepretrageEntity> getListOfZonepretrage() {
        return this.listOfZonepretrage;
    }

    public void setAspnetusers( AspnetusersEntity aspnetusers ) {
        this.aspnetusers = aspnetusers;
    }
    public AspnetusersEntity getAspnetusers() {
        return this.aspnetusers;
    }

    public void setVrstaspasavanja( VrstaspasavanjaEntity vrstaspasavanja ) {
        this.vrstaspasavanja = vrstaspasavanja;
    }
    public VrstaspasavanjaEntity getVrstaspasavanja() {
        return this.vrstaspasavanja;
    }

    public void setListOfPoruka( List<PorukaEntity> listOfPoruka ) {
        this.listOfPoruka = listOfPoruka;
    }
    public List<PorukaEntity> getListOfPoruka() {
        return this.listOfPoruka;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(naziv);
        sb.append("|");
        sb.append(opis);
        sb.append("|");
        sb.append(vrijeme);
        sb.append("|");
        sb.append(potraga);
        sb.append("|");
        sb.append(fazazivotnogciklusa);
        sb.append("|");
        sb.append(longitude);
        sb.append("|");
        sb.append(latitude);
        sb.append("|");
        sb.append(nazivlokacije);
        sb.append("|");
        sb.append(radius);
        return sb.toString(); 
    } 

}
