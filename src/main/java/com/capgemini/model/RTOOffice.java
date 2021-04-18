package com.capgemini.model;
import javax.persistence.*;

/**
 * 
 * List of RTO offices in Maharashtra
 */
@Entity
public class RTOOffice {
	@Id
	private int rtoId;
	private String rtoName;
	
	
	public int getRtoId() {
		return rtoId;
	}
	public void setRtoId(int rtoId) {
		this.rtoId = rtoId;
	}
	public String getRtoName() {
		return rtoName;
	}
	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}
	
	
	public RTOOffice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RTOOffice(int rtoId, String rtoName) {
		super();
		this.rtoId = rtoId;
		this.rtoName = rtoName;
	}
	
	
	@Override
	public String toString() {
		return "RTOOffice [rtoId=" + rtoId + ", rtoName=" + rtoName + "]";
	}
	
	
}
