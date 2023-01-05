package com.cropfield.project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropDto {
	private int CropId;
	private String CropType;
	private String CropName;
	private String quanity;
	private String phoneNumber;
	private String locationName;
	private String state;
	private String district;
	private int pincode;

//	public CropDto() {
//
//	}
//
//	public CropDto(int cropId, String cropType, String cropName, String quanity, String locationName, String country,
//			String state, String district, String mandal, int pincode) {
//		super();
//		CropId = cropId;
//		CropType = cropType;
//		CropName = cropName;
//		this.quanity = quanity;
//
//		this.locationName = locationName;
//		this.country = country;
//		this.state = state;
//		this.district = district;
//		this.mandal = mandal;
//		this.pincode = pincode;
//	}
//
//	public int getCropId() {
//		return CropId;
//	}
//
//	public void setCropId(int cropId) {
//		CropId = cropId;
//	}
//
//	public String getCropType() {
//		return CropType;
//	}
//
//	public void setCropType(String cropType) {
//		CropType = cropType;
//	}
//
//	public String getCropName() {
//		return CropName;
//	}
//
//	public void setCropName(String cropName) {
//		CropName = cropName;
//	}
//
//	public String getQuanity() {
//		return quanity;
//	}
//
//	public void setQuanity(String quanity) {
//		this.quanity = quanity;
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
//
//	@Override
//	public String toString() {
//		return "CropDto [CropId=" + CropId + ", CropType=" + CropType + ", CropName=" + CropName + ", quanity="
//				+ quanity + ", locationName=" + locationName + ", country=" + country + ", state=" + state
//				+ ", district=" + district + ", mandal=" + mandal + ", pincode=" + pincode + "]";
//	}

}
