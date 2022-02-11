package com.caresoft.clinicapp;import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer employeeID, String role) {
    	this.employeeID = employeeID;
    	this.id = this.employeeID;
    	this.role = role;
    }
    
    
    
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pin) {
    	int pinLength = String.valueOf(pin).length();
    	if(pinLength >= 6 ) {
    		this.pin = pin;
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(this.employeeID.equals(confirmedAuthID)) {
    		return true;
    	}
    	else {
			this.authIncident();
			return false;
		}
    }
 
 
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
//    	String allIncident = " ";
//    	for(String incident : this.securityIncidents) {
//    		allIncident += incident;
//    	}
    	return  this.securityIncidents;
    }
    
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }



	public Integer getEmployeeID() {
		return employeeID;
	}



	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}



	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    
    
    
    
    
    // TO DO: Setters & Getters

	
	
}
