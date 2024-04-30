package com.jsp.Data_Transfer_Object;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int H_Id;
	private String HName;
	private String HAddress;
	private String HCity;
	
	@OneToMany
	List<Doctor> doctors;
	
	@OneToMany
	List<Patient> patients;

	public int getH_Id() {
		return H_Id;
	}

	public void setH_Id(int h_Id) {
		H_Id = h_Id;
	}

	public String getHName() {
		return HName;
	}

	public void setHName(String hName) {
		HName = hName;
	}

	public String getHAddress() {
		return HAddress;
	}

	public void setHAddress(String hAddress) {
		HAddress = hAddress;
	}

	public String getHCity() {
		return HCity;
	}

	public void setHCity(String hCity) {
		HCity = hCity;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
	

}
