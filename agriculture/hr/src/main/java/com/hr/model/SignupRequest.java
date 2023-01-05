package com.hr.model;

import java.util.Set;

import javax.validation.constraints.*;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class SignupRequest {
	
	@Transient
    public static final String sequence_Name ="crop_sequence";
	private int userId;
	@NotBlank
	@Size(min = 3, max = 20)
	private String username;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	private Set<String> roles;
	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	
	public SignupRequest() {
		
	}
	public SignupRequest(int userId, @NotBlank @Size(min = 3, max = 20) String username,
			@NotBlank @Size(max = 50) @Email String email, Set<String> roles,
			@NotBlank @Size(min = 6, max = 40) String password
//			String phoneNumber, String locationName, String country,
//			String state, String district, String mandal, int pincode
			) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.password = password;
//		this.phoneNumber = phoneNumber;
//		this.locationName = locationName;
//		this.country = country;
//		this.state = state;
//		this.district = district;
//		this.mandal = mandal;
//		this.pincode = pincode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//	public String getLocationName() {
//		return locationName;
//	}
//	public void setLocationName(String locationName) {
//		this.locationName = locationName;
//	}
//	public String getCountry() {
//		return country;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public String getDistrict() {
//		return district;
//	}
//	public void setDistrict(String district) {
//		this.district = district;
//	}
//	public String getMandal() {
//		return mandal;
//	}
//	public void setMandal(String mandal) {
//		this.mandal = mandal;
//	}
//	public int getPincode() {
//		return pincode;
//	}
//	public void setPincode(int pincode) {
//		this.pincode = pincode;
//	}
	@Override
	public String toString() {
		return "SignupRequest [userId=" + userId + ", username=" + username + ", email=" + email + ", roles=" + roles
				+ ", password=" + password + "]";
	}
	
}
