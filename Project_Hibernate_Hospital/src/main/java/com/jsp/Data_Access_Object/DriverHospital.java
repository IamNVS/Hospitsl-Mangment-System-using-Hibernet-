package com.jsp.Data_Access_Object;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Data_Transfer_Object.Hospital;

public class DriverHospital {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev4");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	Scanner sc = new Scanner(System.in);
	
	
	public void create() {
		
		
		Hospital h = new Hospital();
		
		System.out.println("Enter id of hospital");
		int id = sc.nextInt();
		
		System.out.println("Enter address of hospital");
		String add = sc.next();
		
		System.out.println("Enter city of hospital");
		String city = sc.next();
		
		System.out.println("Enter name of hospital");
		String name = sc.next();
		
		
		h.setH_Id(id);
		h.setHAddress(add);
		h.setHCity(city);
		h.setHName(name);
		
		transaction.begin();
		manager.persist(city);
		manager.persist(id);
		manager.persist(name);
		manager.persist(add);
		System.out.println("Hostial data is created.....");
		transaction.commit();
	

	}
	
	public void updateHospitalName() {
		
		System.out.println("Enter hospital id which you want to update");
		int i = sc.nextInt();
		
		
		Hospital h = manager.find(Hospital.class, i);
		
		if(h!=null) {
			
			transaction.begin();
			System.out.println("Update name of hospital");
			String name = sc.next();
			
			h.setHName(name);
			
			manager.merge(h);
			System.out.println("Hospital name is updated");
			transaction.commit();
			
		}
		else {
			
			System.out.println("Hospital data is not avaible");
		}
		
	}
	
	public void remove() {
		
		
		System.out.println("Enter hospital id which you want to remove");
		int i = sc.nextInt();
		
		Hospital h = manager.find(Hospital.class, i);
		
		if(h!=null) {
			
			transaction.begin();
			manager.remove(h);
			System.out.println("Hospital data is removed for database");
			transaction.commit();
			
		}
		else {
			
			System.out.println("Hospital data is not avaible");
		}
	
		
	}
	
	public void display() {
		
		System.out.println("Enter hospital name which you want to display");
		String i = sc.next();
			
		Query q = manager.createQuery("select h from Hospital h where h.HName=?1");
		q.setParameter(1, i);	
		
		List<Hospital> list = q.getResultList();
		
		for(Hospital h : list) {
			
			System.out.println(h.getH_Id());
			System.out.println(h.getHName());
			System.out.println(h.getHAddress());
			System.out.println(h.getHCity());
		}
		
	}
	
	public void displayAll() {
		
		Query q = manager.createQuery("select h from Hospital h ");
		
		List<Hospital> list = q.getResultList();
		
		for(Hospital h : list) {
			
			System.out.println(h.getH_Id());
			System.out.println(h.getHName());
			System.out.println(h.getHAddress());
			System.out.println(h.getHCity());
		}
	
		
		
	}
}
