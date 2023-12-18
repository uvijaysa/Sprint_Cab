package com.cabmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Driver")

public class Driver extends User {
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain letters")
	@NotBlank(message="Driver name should not be blank")
	private String driverName;
	@NotBlank(message="License should not be blank")
	private String licenseNo;
	
	private Boolean driverAvailability;

	public Driver() {
	}

	public Driver(int userId, String userName, String password, String address, String mobileNumber, String email,
			String roles,String driverName,String licenseNo,Boolean driverAvailability) {
		
		
		super(userId, userName, password,  address, mobileNumber, email);
		this.driverName = driverName;
		this.licenseNo = licenseNo;
		this.driverAvailability = driverAvailability;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Boolean getDriverAvailability() {
		return driverAvailability;
	}

	public void setDriverAvailability(Boolean driverAvailability) {
		this.driverAvailability = driverAvailability;
	}

	@Override
	public String toString() {
		return "Driver [driverName=" + driverName + ", licenseNo=" + licenseNo + ", driverAvailability="
				+ driverAvailability + "]";
	}

}