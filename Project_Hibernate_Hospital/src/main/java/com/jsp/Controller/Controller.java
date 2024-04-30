package com.jsp.Controller;

import java.util.Scanner;

import com.jsp.Data_Access_Object.DriverDoctor;
import com.jsp.Data_Access_Object.DriverHospital;
import com.jsp.Data_Access_Object.DriverMedical_Records;
import com.jsp.Data_Access_Object.DriverPatient;

public class Controller {

	public static void main(String[] args) {
		
		DriverHospital dh = new DriverHospital();
		DriverDoctor dd = new DriverDoctor();
		DriverPatient dp = new DriverPatient();
		DriverMedical_Records dm = new DriverMedical_Records();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("......Welcome.....");
		System.out.println("Select the options \n"+"1.Hospital \n"+"2.Doctor \n"+"3.Patient \n"+"4.Medical Records \n"+"5.Exit" );
		int	val = sc.nextInt();
		
		int i=1;
		
	while(i>0) {
			
		
		
		switch(val) {
		
		case 1 : 
			
			System.out.println("Select the options \n"+"1.Create the Hospital data \n"+"2.Update Hospital name \n"+"3.Remove the Hospital \n"+"4.Diaply the perticular Hospital \n"+"5.Display all Hospital \n"+"6.Exit");
			int val1 = sc.nextInt();
			switch(val1) {
			
			case 1:
				dh.create();
				System.out.println("Do you want to add Doctor detials \n press Y/y for yes and N/n for no");
				char val11 = sc.next().charAt(0);
				
				if(val11=='y' || val11=='Y') {

					dd.createDoctor();
	
				}
				else if (val11=='N' ||val11=='n'){
					
					break;
				}
				break;
				
			case 2:
				dh.remove();
				break;
				
			case 3:
				dh.updateHospitalName();
				break;
			
			case 4:
				dh.display();
				break;
			
			case 5:
				dh.displayAll();
				break;
				
			case 6:
				System.out.println("Thank you");
				break;
				
			default :
				System.out.println("Invalide option");
				
			}
			break;
		
		case 2:
			
			System.out.println("Select the options \n"+"1.Create the Doctor data \n"+"2.Update Doctor salary \n"+"3.Remove the Doctor data \n"+"4.Diaply the perticular Doctor \n"+"5.Display all Doctor \n"+"6.Exit");
			int val2 = sc.nextInt();
			switch (val2) {
			
			case 1:
				dd.createDoctor();
				System.out.println("Do you want to add Patient y/Y for yes and n/N for no ");
				char val21 = sc.next().charAt(0);
				if(val21=='y' || val21=='Y') {
					
					dp.createPatient();
					
				}
				else if(val21=='n' || val21=='N') {
					
					break;
				}
				break;
				
			case 2:
				dd.RemoveDoc();
				break;
				
			case 3:
				dd.updateSalary();
				break;
				
			case 4:
				dd.displayDoc();
				break;
				
			case 5:
				dd.displayAllDoc();
				break;
				
			case 6:
				System.out.println("Thank you");
				break;
				
			default :
				System.out.println("Invalide option");
				
			}
			break;
		
		case 3:
			
			System.out.println("Select the options \n"+"1.Create the Patient data \n"+"2.Remove the Patient data \n"+"3.Diaply the perticular Patient \n"+"4.Display all Patient \n"+"5.Exit");
			int val3 = sc.nextInt();
			switch (val3) {
			
			case 1:
				dp.createPatient();
				System.out.println("Do you to add patient medical record y/Y for yes and n/N for no ");
				char val31 = sc.next().charAt(0);
				if(val31=='y' || val31=='Y') {
					
					dm.createMR();
					
				}
				
				else if(val31=='n' || val31=='N') {
					
					break;
				}
				break;
				
			case 2:
				dp.Removepat();
				break;
				
			case 3:
				dp.displayPat();
				break;
				
			case 4:
				dp.displayAllPat();
				break;
				
			case 5:
				System.out.println("Thank you...");
				break;
				
			default :
				System.out.println("Invalide option");
	
			}
			break;
			
		case 4:
			
			System.out.println("Select the options \n"+"1.Create the Medical records  \n"+"2.Update Medical records date \n"+"3.Remove the Medical records  \n"+"4.Diaply the perticular Medical records \n"+"5.Exit");
			int val4 = sc.nextInt();
			switch (val4) {
			
			case 1:
				dm.createMR();
				System.out.println("Do you want display perticular Patient details y/Y for yes and n/N for no  ");
				char val41 = sc.next().charAt(0);
				if(val41=='y' || val41=='Y') {
					
					dp.displayPat();
	
				}
				
				else if(val41=='n' || val41=='N') {
					
					break;
				}
				System.out.println("Do you want display perticular Doctors details y/Y for yes and n/N for no  ");
				char val42 = sc.next().charAt(0);
				if(val42=='y' || val42=='Y') {
					
					dd.displayDoc();
	
				}
				
				else if(val42=='n' || val42=='N') {
					
					break;
				}
				break;
				
			case 2:
				dm.updateDateMR();
				break;
				
			case 3:
				dm.RemoveMr();
				System.out.println("Do you want remove perticular Patient details y/Y for yes and n/N for no  ");
				char val43 = sc.next().charAt(0);
				if(val43=='y' || val43=='Y') {
					
					dp.Removepat();
	
				}
				
				else if(val43=='n' || val43=='N') {
					
					break;
				}
				break;
				
			case 4:
				dm.displayMr();
				break;
			
				
			case 5:
				System.out.println("Thank you....");
				break;
				
			default :
				System.out.println("Invalide option");
				
			}
			break;
			
			
		case 5:
			System.out.println("Thank you for visiting...");
			break;
			
		default :
			System.out.println("Invalide option ");
		
		}
		
		if(val==5) {
			
			break;
		}
		
	}
	
	}
}
