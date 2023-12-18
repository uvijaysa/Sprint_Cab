package com.cabmanagementsystem.service;
 
import java.time.LocalDate;
import java.util.List;
 
import com.cabmanagementsystem.dto.RideDTO;
 
public interface IRideService {
	public RideDTO addRide(RideDTO ride);
	public RideDTO updateRide(RideDTO ride);
	public RideDTO cancelRide(int rideId);
	public List<RideDTO> viewAllRide();
	public List<RideDTO> viewRideByCustomerId(int customerId);
	public List<RideDTO> viewRideByDriverId(int driverId);
	public List<RideDTO> viewRideByCabId(int cabId);
	public List<RideDTO> viewRideByStatus(String status);
	public List<RideDTO> viewRideByDate(LocalDate date);
 
}