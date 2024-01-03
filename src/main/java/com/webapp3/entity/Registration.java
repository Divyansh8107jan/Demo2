package com.webapp3.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="registration")
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min = 2 , message = "first name should be at least 2 characters")
	@Column(name = "first_Name", length = 45)
	private String firstName;	//first_Name
	
	@Column(name = "last_Name", length = 45)
	private String lastName;
	
	@Email
	@Column(name = "email" , unique = true ,length = 128)
	private String email;
	
	@Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
	@Column(name = "mobile" )
	private String mobile;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

}
