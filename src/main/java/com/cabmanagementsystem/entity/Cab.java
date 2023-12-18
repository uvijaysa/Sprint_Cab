package com.cabmanagementsystem.entity;

import java.util.Objects;

import com.cabmanagementsystem.dto.DriverDTO;
import com.cabmanagementsystem.util.CabType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name="Cab")
public class Cab {
	
	@Id

	private int cabId;
	
	
	@NotNull(message = "CabType can not be null")
	private CabType cabType;
	@OneToOne
	//(cascade=CascadeType.ALL)
	@NotNull(message = "driver can not be null")
	private Driver driver;
	@Positive
	@NotNull(message = "rateper km can not be null")
	private double rateperkm;
	@Pattern(regexp = "^[A-Z0-9]{7}$" , message = "Enter valid registration number")
	@NotBlank(message = "Registration number can not be blank")
	private String registrationNo;
	private Boolean cabAvailability;
	@NotBlank(message = "CurrentLocaation can not be blank")
	private String currentLocation;

	public Cab() {
	}

	public Cab(int cabId, CabType cabType, Driver driver, double rateperkm, String registrationNo,
			Boolean cabAvailability, String currentLocation) {
		super();
		this.cabId = cabId;
		this.cabType = cabType;
		this.driver = driver;
		this.rateperkm = rateperkm;
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

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public double getRateperkm() {
		return rateperkm;
	}

	public void setRateperkm(double rateperkm) {
		this.rateperkm = rateperkm;
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
		return "Cab [cabId=" + cabId + ", rateperkm=" + rateperkm + ", registrationNo=" + registrationNo
				+ ", cabAvailability=" + cabAvailability + ", currentLocation=" + currentLocation + "]";
	}



	
	

}