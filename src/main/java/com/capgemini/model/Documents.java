package com.capgemini.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Documents {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="documents_seq")
	@SequenceGenerator(name="documents_seq",sequenceName="documents_seq", allocationSize=1)
	private int docId;
	// necessary documents need to upload
	//@JsonIgnore
	private String photo=null;
	//@JsonIgnore
	private String idProof=null;
	//@JsonIgnore
	private String addressProof=null;
	public Documents(int docId, String photo, String idProof, String addressProof) {
		super();
		this.docId = docId;
		this.photo = photo;
		this.idProof = idProof;
		this.addressProof = addressProof;
	}
	public Documents() {
		super();
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId=docId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public String getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}
	@Override
	public String toString() {
		return "Documents [docId=" + docId + ", photo=" + photo + ", idProof=" + idProof + ", addressProof="
				+ addressProof + "]";
	}
	
	
	
}
