package com.webapp3.dto;

import java.util.List;

import com.webapp3.entity.Registration;

public class ReadRegistrationDto {
	
	private List<Registration> registrations;
	private String message;
	
	
	public List<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
