package com.caresoft.clinicapp;

import java.time.LocalDate;
import java.util.Date;

public class TestCareSoft {

	public static void main(String[] args) {
		Physician carl = new Physician(124);
		System.out.println(carl.id);
		System.out.println(carl.assignPin(1234)); 
		System.out.println(carl.accessAuthorized(124));
//		carl.newPatientNotes("new patient tom", "tom", 2002-12-12);
		
		AdminUser dan = new AdminUser(230, "doctor");
		System.out.println(dan.accessAuthorized(45) + " 45 * \n");
		System.out.println(dan.accessAuthorized(230) + " 230 * \n");
		System.out.println(dan.accessAuthorized(214) + " 214 * \n");
		dan.newIncident("hello World");
		System.out.println(dan.getSecurityIncidents());
		
	}

}
