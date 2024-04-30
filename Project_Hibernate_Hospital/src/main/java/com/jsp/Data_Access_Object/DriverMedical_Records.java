package com.jsp.Data_Access_Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Data_Transfer_Object.Doctor;
import com.jsp.Data_Transfer_Object.Hospital;
import com.jsp.Data_Transfer_Object.Medica_Records;
import com.jsp.Data_Transfer_Object.Patient;

public class DriverMedical_Records {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev4");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	Scanner sc = new Scanner(System.in);
	
	public void createMR() {
		
		System.out.println("Enter id of Paitent");
		int id = sc.nextInt();
		
		Patient p = manager.find(Patient.class,id);
		
		if(p!=null) {
			
			transaction.begin();
			Medica_Records mr = new Medica_Records();
			System.out.println("Enter id of Medical Record ");
			int mid = sc.nextInt();
			System.out.println("Enter date of patient visiting ");
			String date = sc.next();
			System.out.println("Enter problem of patient ");
			String problem = sc.next();
			
			
			List<Medica_Records> MRList = new ArrayList<Medica_Records>();
			MRList.add(mr);
			
			mr.setMR_Id(mid);
			mr.setDate(date);
			mr.setProblem(problem);
			

			p.setMedica_Records(MRList);
			mr.setPatient(p);
			
			manager.persist(mid);
			manager.persist(date);
			manager.persist(problem);
			System.out.println("Medical record data is created.....");
			transaction.commit();

		}		
		else{
			
			System.out.println("Patient is not present");
			
		}
	}
	
	public void updateDateMR() {
		
		
		System.out.println("Enter medical records id which you want to update");
		int i = sc.nextInt();
		
		
		Medica_Records mr = manager.find(Medica_Records.class, i);
		
		if(mr!=null) {
			
			transaction.begin();
			System.out.println("Update date of Medical records");
			String date = sc.next();
			
			mr.setDate(date);
			
			manager.merge(mr);
			System.out.println("Medical records are updated");
			transaction.commit();
			
		}
		else {
			
			System.out.println("Medical record data is not avaible");
		}
	
	}


	public void RemoveMr() {
		
		System.out.println("Enter Medical Records id which you want to remove");
		int i = sc.nextInt();
		
		Medica_Records mr = manager.find(Medica_Records.class, i);
		
		if(mr!=null) {
			
			transaction.begin();
			manager.remove(mr);
			System.out.println("Medical records are removed for database");
			transaction.commit();
			
		}
		else {
			
			System.out.println("Medical records data is not avaible");
		}
	
	}
	
	public void displayMr() {
		
		System.out.println("Enter Patient id which medical records you want to display");
		int i = sc.nextInt();
		
		Patient p = manager.find(Patient.class, i);
		
		if(p!=null) {
			
			List<Medica_Records> list = p.getMedica_Records();
			
			
			
			for(Medica_Records m : list) {
				
				System.out.println(m.getMR_Id());
				System.out.println(m.getProblem());
				System.out.println(m.getDate());
				
			}
			
			
		}
	}
	
	

}
