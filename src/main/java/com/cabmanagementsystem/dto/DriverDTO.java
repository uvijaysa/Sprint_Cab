package com.cabmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class DriverDTO extends UserDTO{

	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain letters")
	@NotBlank(message="Driver name should not be blank")
	private String driverName;
	@NotBlank(message="License should not be blank")
	private String licenseNo;
	private boolean driverAvailability;
	
	public DriverDTO() {
		super();
	}
	public DriverDTO(int userId, String userName, String password, String address, String mobileNumber, String email,
			 String driverName, String licenseNo, boolean driverAvailability) {
		super(userId, userName, password, address, mobileNumber, email);
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


	public boolean getDriverAvailability() {
		return driverAvailability;
	}


	public void setDriverAvailability(boolean driverAvailability) {
		this.driverAvailability = driverAvailability;
	}
	
	
	
}