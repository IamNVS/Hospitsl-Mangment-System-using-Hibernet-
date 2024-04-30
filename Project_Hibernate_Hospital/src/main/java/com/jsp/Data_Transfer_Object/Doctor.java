package com.jsp.Data_Transfer_Object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int D_Id;
	private String D_Name;
	private String D_Qualification;
	private int D_Salary;
	
	@ManyToOne
	Hospital hospital;
	
	
	public int getD_Id() {
		return D_Id;
	}

	public void setD_Id(int d_Id) {
		D_Id = d_Id;
	}

	public String getD_Name() {
		return D_Name;
	}

	public void setD_Name(String d_Name) {
		D_Name = d_Name;
	}

	public String getD_Qualification() {
		return D_Qualification;
	}

	public void setD_Qualification(String d_Qualification) {
		D_Qualification = d_Qualification;
	}

	public int getD_Salary() {
		return D_Salary;
	}

	public void setD_Salary(int d_Salary) {
		D_Salary = d_Salary;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	

}
