package com.hr.model;

public class PurchaseCrop {
	private int cropId;
	private String cropType;
	private String cropName;
	private Long accountNumber;
	private Double amount;
	public PurchaseCrop() {
		
	}
	public PurchaseCrop(int cropId, String cropType, String cropName, Long accountNumber, Double amount) {
		super();
		this.cropId = cropId;
		this.cropType = cropType;
		this.cropName = cropName;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PurchaseCrop [cropId=" + cropId + ", cropType=" + cropType + ", cropName=" + cropName
				+ ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}

}
