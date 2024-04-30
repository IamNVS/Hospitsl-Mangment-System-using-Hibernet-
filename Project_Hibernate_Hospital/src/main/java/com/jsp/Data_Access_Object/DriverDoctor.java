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


public class DriverDoctor {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev4");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	Scanner sc = new Scanner(System.in);
	
	
	
	public void createDoctor() {
		
		System.out.println("Enter id of hospital");
		int id = sc.nextInt();
		
		
		Hospital h = manager.find(Hospital.class, id);
		
		if(h!=null) {
			
			transaction.begin();
			Doctor d =new Doctor();
			System.out.println("Enter id of doctor ");
			int Did = sc.nextInt();
			System.out.println("Enter name of doctor ");
			String name = sc.next();
			System.out.println("Enter Qualification of doctor ");
			String quo = sc.next();
			System.out.println("Enter salary of doctor ");
			int sal = sc.nextInt();
		
			List<Doctor> Doctorlist = new ArrayList<Doctor>();
			Doctorlist.add(d);
			
			d.setD_Id(Did);
			d.setD_Name(name);
			d.setD_Qualification(quo);
			d.setD_Salary(sal);
			
			h.setDoctors(Doctorlist);
			d.setHospital(h);
			
			manager.persist(quo);
			manager.persist(name);
			manager.persist(Did);
			manager.persist(sal);
			System.out.println("Welcome Dr."+d.getD_Name()+"to"+h.getHName());
			System.out.println("Doctor data is created.....");
			transaction.commit();
			
			
		}
		
		else{
			
			System.out.println("Hospital is not present");
			
		}
	}
	

	public void updateSalary() {
		
		
		System.out.println("Enter doctor id which you want to update");
		int i = sc.nextInt();
		
		
		Doctor d = manager.find(Doctor.class, i);
		
		if(d!=null) {
			
			transaction.begin();
			System.out.println("Update name of hospital");
			int sal = sc.nextInt();
			
			d.setD_Salary(sal);
			
			manager.merge(d);
			System.out.println("Doctor salary is updated");
			transaction.commit();
			
		}
		else {
			
			System.out.println("Doctor data is not avaible");
		}
	
	}

	public void RemoveDoc() {
		
		System.out.println("Enter Doctor id which you want to remove");
		int i = sc.nextInt();
		
		Doctor d = manager.find(Doctor.class, i);
		
		if(d!=null) {
			
			transaction.begin();
			manager.remove(d);
			System.out.println("Doctor data is removed for database");
			transaction.commit();
			
		}
		else {
			
			System.out.println("Doctor data is not avaible");
		}
	
	}
	
	
	public void displayDoc() {
		
		System.out.println("Enter doctor name which you want to display");
		String i = sc.next();
			
		Query q = manager.createQuery("select d from Doctor d where h.HName=?1");
		q.setParameter(1, i);	
		
		List<Doctor> list = q.getResultList();
		
		for(Doctor h : list) {
			
			System.out.println(h.getD_Id());
			System.out.println(h.getD_Name());
			System.out.println(h.getD_Qualification());
			System.out.println(h.getD_Salary());
		}
		
		
	}
	
	public void displayAllDoc() {
		
		
		System.out.println("Enter Hospital id which doctor data you want to display");
		int i = sc.nextInt();
		
		Hospital h = manager.find(Hospital.class, i);
		
		if(h!=null) {
			
			List<Doctor> list = h.getDoctors();
			
			for(Doctor d : list) {
				
				System.out.println(d.getD_Id());
				System.out.println(d.getD_Name());
				System.out.println(d.getD_Qualification());
				System.out.println(d.getD_Salary());
				
			}
			
		
	
		}	
	}
}
