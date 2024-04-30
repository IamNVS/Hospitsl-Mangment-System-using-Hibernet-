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
import com.jsp.Data_Transfer_Object.Patient;

public class DriverPatient {

	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev4");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	Scanner sc = new Scanner(System.in);
	
	public void createPatient() {
		
		System.out.println("Enter id of hospital");
		int id = sc.nextInt();
		
		Hospital h = manager.find(Hospital.class, id);
		
		if(h!=null) {
			
			transaction.begin();
			Patient p =new Patient();
			System.out.println("Enter id of patient ");
			int Pid = sc.nextInt();
			System.out.println("Enter name of patient ");
			String name = sc.next();
			System.out.println("Enter Diagnosis of patient ");
			String dia = sc.next();
			System.out.println("Enter Address of patient ");
			String add = sc.next();
		
			List<Patient> PatientList = new ArrayList<Patient>();
			PatientList.add(p);
			
			p.setP_Id(Pid);
			p.setPName(name);
			p.setPDiagnosis(dia);
			p.setPAddress(add);
			
			
			h.setPatients(PatientList);
			p.setHospital(h);;
			
			manager.persist(Pid);
			manager.persist(name);
			manager.persist(dia);
			manager.persist(add);
			System.out.println("Welcome "+p.getPName()+"to"+h.getHName());
			System.out.println("Patient data is created.....");
			transaction.commit();
			
			
		}
		
		else{
			
			System.out.println("Hospital is not present");
			
		}
	}
	
	public void Removepat() {
		
		System.out.println("Enter Patient id which you want to remove");
		int i = sc.nextInt();
		
		Patient p = manager.find(Patient.class, i);
		
		if(p!=null) {
			
			transaction.begin();
			manager.remove(p);
			System.out.println("Patient data is removed for database");
			transaction.commit();
			
		}
		else {
			
			System.out.println("Patient data is not avaible");
		}
	
	}
	


	public void displayPat() {
		
		System.out.println("Enter Patient name which you want to display");
		String i = sc.next();
			
		Query q = manager.createQuery("select p from Patient d where p.PName=?1");
		q.setParameter(1, i);	
		
		List<Patient> list = q.getResultList();
		
		for(Patient p : list) {
			
			System.out.println(p.getP_Id());
			System.out.println(p.getPName());
			System.out.println(p.getPDiagnosis());
			System.out.println(p.getPAddress());
		}
		
		
	}
	
	public void displayAllPat() {
		
		System.out.println("Enter Hospital id which doctor data you want to display");
		int i = sc.nextInt();
		
		Hospital h = manager.find(Hospital.class, i);
		
		if(h!=null) {
			
			List<Patient> list = h.getPatients();
			
			for(Patient p : list) {
				
				System.out.println(p.getP_Id());
				System.out.println(p.getPName());
				System.out.println(p.getPDiagnosis());
				System.out.println(p.getPAddress());
				
			}
			
		}
		
	}
	
	

}
