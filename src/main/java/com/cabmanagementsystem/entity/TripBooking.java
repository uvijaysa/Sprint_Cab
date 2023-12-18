package com.cabmanagementsystem.entity;

import java.time.LocalDate;

import com.cabmanagementsystem.util.BookingStatus;
import com.cabmanagementsystem.util.CabType;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name="TripBooking")
public class TripBooking{
	
	@Id
	
	private int tripBookingId;
	@ManyToOne
	//(cascade = CascadeType.MERGE)
    @NotNull(message = "Customer cannot be null")
    private Customer customer;

	//@Enumerated(EnumType.STRING)
    @NotNull(message = "Cab type cannot be null")
    private CabType cabType;

    @NotBlank(message = "Pickup location cannot be blank")
    private String pickupLocation;

    @NotBlank(message = "Drop-off location cannot be blank")
    private String dropoffLocation;

    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;

   
    @NotNull(message = "Booking type cannot be null")
    
    private BookingStatus bookingStatus;

    @Positive(message = "Distance must be a positive value")
    private Double distanceInKm;

    @NotNull(message = "Bill cannot be null")
    @Positive(message = "Bill must be a positive value")
    private Double bill;
	
	public TripBooking()
	{
		
	}

	public TripBooking(int tripBookingId, Customer customer, CabType cabType, String pickupLocation,
			String dropoffLocation,  LocalDate startDate, BookingStatus bookingStatus,
			Double distanceInKm, Double bill) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
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

	public Double getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(Double distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public Double getBill() {
		return bill;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", customer=" + customer + ", cabType=" + cabType
				+ ", pickupLocation=" + pickupLocation + ", dropoffLocation=" + dropoffLocation + ", startDate="
				+ startDate + ", bookingStatus=" + bookingStatus + ", distanceInKm=" + distanceInKm + ", bill=" + bill
				+ "]";
	}

	
	
	
	
	
	
	
	
}
