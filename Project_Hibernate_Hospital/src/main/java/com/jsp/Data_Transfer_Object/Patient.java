package com.jsp.Data_Transfer_Object;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int P_Id;
	private String PName;
	private String PDiagnosis;
	private String PAddress;
	
	
	@OneToMany
	List<Medica_Records> medica_Records;
	
	@ManyToOne
	Hospital hospital;
	

	
	public int getP_Id() {
		return P_Id;
	}

	public void setP_Id(int p_Id) {
		P_Id = p_Id;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public String getPDiagnosis() {
		return PDiagnosis;
	}

	public void setPDiagnosis(String pDiagnosis) {
		PDiagnosis = pDiagnosis;
	}

	public String getPAddress() {
		return PAddress;
	}

	public void setPAddress(String pAddress) {
		PAddress = pAddress;
	}

	public List<Medica_Records> getMedica_Records() {
		return medica_Records;
	}

	public void setMedica_Records(List<Medica_Records> medica_Records) {
		this.medica_Records = medica_Records;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	

}
