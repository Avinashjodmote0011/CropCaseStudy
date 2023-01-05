package com.hr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropDto {
	
	private int cropId;
	private String cropType;
	private String cropName;
	private String quanity;
	private String phoneNumber;
	private String locationName;
	private String state;
	private String district;
	private int pincode;
	private int userId;

}
