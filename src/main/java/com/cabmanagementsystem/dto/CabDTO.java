package com.cabmanagementsystem.dto;

import com.cabmanagementsystem.util.CabType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CabDTO {
	
	private int cabId;
	@NotNull(message = "CabType can not be null")
	private CabType cabType;
	@NotNull(message = "driver can not be null")
	private DriverDTO driver;
	@Positive
	@NotNull(message = "rateper km can not be null")
	private double ratePerKm;
	@Pattern(regexp = "^[A-Z0-9]{7}$" , message = "Enter valid registration number")
	@NotBlank(message = "Registration number can not be blank")
	private String registrationNo;
	private Boolean cabAvailability;
	@NotBlank(message = "CurrentLocaation can not be blank")
	private String currentLocation;
	
	public CabDTO() {
		super();
	}
	public CabDTO(int cabId, CabType cabType, DriverDTO driver, double ratePerKm, String registrationNo,
			Boolean cabAvailability, String currentLocation) {
		super();
		this.cabId = cabId;
		this.cabType = cabType;
		this.driver = driver;
		this.ratePerKm = ratePerKm;
		this.registrationNo = registrationNo;
		this.cabAvailability = cabAvailability;
		this.currentLocation = currentLocation;
	}


	public int getCabId() {
		return cabId;
	}


	public void setCabId(int cabId) {
		this.cabId = cabId;
	}


	public CabType getCabType() {
		return cabType;
	}


	public void setCabType(CabType cabType) {
		this.cabType = cabType;
	}


	public DriverDTO getDriver() {
		return driver;
	}


	public void setDriver(DriverDTO driver) {
		this.driver = driver;
	}


	public double getRatePerKm() {
		return ratePerKm;
	}


	public void setRatePerKm(double ratePerKm) {
		this.ratePerKm = ratePerKm;
	}


	public String getRegistrationNo() {
		return registrationNo;
	}


	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}


	public Boolean getCabAvailability() {
		return cabAvailability;
	}


	public void setCabAvailability(Boolean cabAvailability) {
		this.cabAvailability = cabAvailability;
	}


	public String getCurrentLocation() {
		return currentLocation;
	}


	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}


	@Override
	public String toString() {
		return "CabDTO [cabId=" + cabId + ", cabType=" + cabType + ", ratePerKm=" + ratePerKm + ", registrationNo="
				+ registrationNo + ", cabAvailability=" + cabAvailability + ", currentLocation=" + currentLocation
				+ "]";
	}

	
}