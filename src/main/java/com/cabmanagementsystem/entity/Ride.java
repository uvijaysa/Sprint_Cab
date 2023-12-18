package com.cabmanagementsystem.entity;
import java.time.LocalDate;
import java.time.LocalTime;

import com.cabmanagementsystem.util.RideStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "Ride")
public class Ride {
	
	  @Id
	   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int rideId;

	    @ManyToOne
	    //(cascade = CascadeType.ALL)
	    @NotNull(message = "Customer cannot be null")
	    private Customer customer;

	    @ManyToOne
	    //(cascade = CascadeType.ALL)
	    @NotNull(message = "Cab cannot be null")
	    private Cab cab;

	    @NotBlank(message = "Pickup location cannot be blank")
	    private String pickupLocation;

	    @NotBlank(message = "Drop-off location cannot be blank")
	    private String dropoffLocation;

	    @NotNull(message = "Start time cannot be null")
	    private LocalTime startTime;

	    @NotNull(message = "End time cannot be null")
	    private LocalTime endTime;

	    @NotNull(message = "Ride status cannot be null")
	    private RideStatus rideStatus;

	    @NotNull(message = "Date cannot be null")
	    private LocalDate date;
    
    
    public Ride() {}
    public Ride(int rideId, Customer customer, Cab cab, String pickupLocation, String dropoffLocation,
        LocalTime startTime, LocalTime endTime, RideStatus rideStatus, LocalDate date) {
        super();
        this.rideId = rideId;
        this.customer = customer;
        this.cab = cab;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rideStatus = rideStatus;
        this.date = date;
    }
    //Setters and Getters
    public int getRideId() {
        return rideId;
    }
    public void setRideId(int rideId) {
        this.rideId = rideId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Cab getCab() {
        return cab;
    }
    public void setCab(Cab cab) {
        this.cab = cab;
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
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public RideStatus getRideStatus() {
        return rideStatus;
    }
    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    //toString 
    @Override
    public String toString() {
        return "Ride [rideId=" + rideId + ", pickupLocation=" + pickupLocation + ", dropoffLocation=" + dropoffLocation +
            ", startTime=" + startTime + ", endTime=" + endTime + ", date=" + date + "]";
    }
}