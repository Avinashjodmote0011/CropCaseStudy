package com.cropfield.project.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cropdetail")
public class Crop {
	
	@Transient
	public static final String sequence_Name ="crop_sequence";
	
	@Id
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
