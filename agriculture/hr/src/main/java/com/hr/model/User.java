package com.hr.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "userDetails")
public class User {
	
	@Id
	private int userId;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@DBRef
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	

	public User(int userId, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password 
//			String phoneNumber, String locationName, String country,
//			String state, String district, String mandal, int pincode
			) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
//		this.phoneNumber = phoneNumber;
//		this.locationName = locationName;
//		this.country = country;
//		this.state = state;
//		this.district = district;
//		this.mandal = mandal;
//		this.pincode = pincode;
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getLocationName() {
//		return locationName;
//	}
//
//	public void setLocationName(String locationName) {
//		this.locationName = locationName;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public String getDistrict() {
//		return district;
//	}
//
//	public void setDistrict(String district) {
//		this.district = district;
//	}
//
//	public String getMandal() {
//		return mandal;
//	}
//
//	public void setMandal(String mandal) {
//		this.mandal = mandal;
//	}
//
//	public int getPincode() {
//		return pincode;
//	}
//
//	public void setPincode(int pincode) {
//		this.pincode = pincode;
//	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", roles="
				+ roles + "]";
	}

}