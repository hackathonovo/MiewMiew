package hr.miewmiew.MiewMiew.dtomodel;

import java.util.Date;

public class NedostupanEntityDto {
	private Integer id;
	
	private Date od;
	
	private Date doo;
	
	private AspnetusersEntityDto aspnetusers;
	
	public NedostupanEntityDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getOd() {
		return od;
	}
	
	public void setOd(Date od) {
		this.od = od;
	}
	
	public Date getDoo() {
		return doo;
	}
	
	public void setDoo(Date doo) {
		this.doo = doo;
	}
	
	public AspnetusersEntityDto getAspnetusers() {
		return aspnetusers;
	}
	
	public void setAspnetusers(AspnetusersEntityDto aspnetusers) {
		this.aspnetusers = aspnetusers;
	}
	
}
