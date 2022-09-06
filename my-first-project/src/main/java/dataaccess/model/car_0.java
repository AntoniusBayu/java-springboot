package dataaccess.model;

import java.io.Serializable;
import java.time.Instant;

public class car_0 implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long carid;
	private String carname;
	private Instant createddate;
	private Boolean isactive;
	public Long getCarid() {
		return carid;
	}
	public void setCarid(Long carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public Instant getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Instant createddate) {
		this.createddate = createddate;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	
	
}
