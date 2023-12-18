package com.cabmanagementsystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cabmanagementsystem.entity.Customer;
import com.cabmanagementsystem.util.BookingStatus;
import com.cabmanagementsystem.util.CabType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TripBookingDTO {

	private int tripBookingId;
	 @NotNull(message = "Customer cannot be null")
	    private CustomerDTO customer;

	 
	 @NotNull(message = "Cab type cannot be null")
	    private CabType cabType;

	    @NotBlank(message = "Pickup location cannot be blank")
	    private String pickupLocation;

	    @NotBlank(message = "Drop-off location cannot be blank")
	    private String dropoffLocation;

	    @NotNull(message = "Start date cannot be null")
	    private LocalDate startDate;

	    
	    @NotNull(message = "Booking status cannot be null")
	    private BookingStatus bookingStatus;

	    @Positive(message = "Distance must be a positive value")
	    private Double distanceInKm;

	    @NotNull(message = "Bill cannot be null")
	    @Positive(message = "Bill must be a positive value")
	    private Double bill;
	
	public TripBookingDTO() {
		super();
	}

	public TripBookingDTO(int tripBookingId, CustomerDTO customer, CabType cabType, String pickupLocation,
			String dropoffLocation,   LocalDate startDate, BookingStatus bookingStatus,
			double distanceInKm, double bill) {
		super();
		this.tripBookingId = tripBookingId;
		this.customer = customer;
		this.cabType = cabType;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		
		this.startDate = startDate;
		this.bookingStatus = bookingStatus;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}

	public int getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public CabType getCabType() {
		return cabType;
	}

	public void setCabType(CabType cabType) {
		this.cabType = cabType;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropoffLocation() {
		return dropoffLocation;
	}

	public void setDropoffLocation(String dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}

	

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public double getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(double distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "TripBookingDTO [tripBookingId=" + tripBookingId + ", customer=" + customer + ", cabType=" + cabType
				+ ", pickupLocation=" + pickupLocation + ", dropoffLocation=" + dropoffLocation + ", startDate="
				+ startDate + ", bookingStatus=" + bookingStatus + ", distanceInKm=" + distanceInKm + ", bill=" + bill
				+ "]";
	}



	

	
	
}