package com.cabmanagementsystem.dto;
import java.time.LocalDate;
import java.time.LocalTime;

import com.cabmanagementsystem.entity.Cab;
import com.cabmanagementsystem.entity.Customer;
import com.cabmanagementsystem.util.RideStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class RideDTO {
	
    private int rideId;
   
    @NotNull(message = "Customer cannot be null")
    private CustomerDTO customer;

  
    @NotNull(message = "Cab cannot be null")
    private CabDTO cab;

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


    
    //Default Constructor
    public RideDTO() {
        super();
    }
    //Constructor
    public RideDTO(int rideId, CustomerDTO customer, CabDTO cab, String pickupLocation, String dropoffLocation,
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
    //Setters and getters
    public int getRideId() {
        return rideId;
    }
    public void setRideId(int rideId) {
        this.rideId = rideId;
    }
    public CustomerDTO getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    public CabDTO getCab() {
        return cab;
    }
    public void setCab(CabDTO cab) {
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
        return "RideDTO [rideId=" + rideId + ", pickupLocation=" + pickupLocation + ", dropoffLocation=" +
            dropoffLocation + ", startTime=" + startTime + ", endTime=" + endTime + ", rideStatus=" + rideStatus +
            ", date=" + date + "]";
    }
}