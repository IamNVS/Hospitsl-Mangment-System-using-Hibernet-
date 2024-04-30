package com.jsp.Data_Transfer_Object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Medica_Records {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MR_Id;
	private String Date;
	private String Problem;
	
	@ManyToOne
	Patient patient;

	public int getMR_Id() {
		return MR_Id;
	}

	public void setMR_Id(int mR_Id) {
		MR_Id = mR_Id;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getProblem() {
		return Problem;
	}

	public void setProblem(String problem) {
		Problem = problem;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
