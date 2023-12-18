package com.cabmanagementsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabmanagementsystem.dto.TripBookingDTO;
import com.cabmanagementsystem.service.TripBookingService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/tripBooking")
public class TripBookingController {

	@Autowired
	
	private TripBookingService tservice;



	@PostMapping("/add")
	public TripBookingDTO addTripBooking(@Valid @RequestBody TripBookingDTO to) {
       System.out.println("Controller Called");
		return tservice.addTripBooking(to);
	}

	@GetMapping("/view")
	public List<TripBookingDTO> viewTripBooking() {

		return tservice.viewAllBookings();
	}

	@GetMapping("/viewBookingId/{id}")
	public TripBookingDTO viewBookingByBookingId(@PathVariable("id") int id) {
		return tservice.viewBookingByBookingId(id);
	}

	@GetMapping("/viewBookingStatus/{status}")
	public List<TripBookingDTO> viewBookingByBookingStatus(@PathVariable("status") String status) {
		return tservice.viewBookingByBookingStatus(status);
	}

	@GetMapping("/viewOrderByDate")
	public List<TripBookingDTO> viewBookingsByDatewiseSortingOrder() {
		return tservice.viewBookingsByDatewiseSortingOrder();
	}

	@GetMapping("/cancelTrip/{id}")
	public TripBookingDTO cancleTripBooking(@PathVariable("id") int id) {
		return tservice.cancleTripBooking(id);
	}

	@GetMapping("/viewCustomerId/{customerId}")
	public List<TripBookingDTO> viewBookingByCustomerId(@PathVariable("customerId") int customerId) {
		return tservice.viewBookingByCustomerId(customerId);
	}

	@GetMapping("/viewBookingsByDates/{customerId}/{fromDate}/{toDate}")
	public List<TripBookingDTO> viewBookingsByCustomerBasedOnDates(@PathVariable("customerId") Integer customerId,
			@PathVariable("fromDate") LocalDate fromDate, @PathVariable("toDate") LocalDate toDate) {

		return tservice.viewBookingsByCustomerBasedOnDates(customerId, fromDate, toDate);

	}

	@GetMapping("/viewtripBookingByCabType/{cabType}")
	public List<TripBookingDTO> viewBookingByCabType(@PathVariable("cabType") String cabType) {
		return tservice.viewBookingByCabType(cabType);
	}

	@PutMapping("/updaterip")
	public TripBookingDTO updateTripBooking(@Valid @RequestBody TripBookingDTO tripBookingDTO) {
		return tservice.updateTripBooking(tripBookingDTO);
	}

}
