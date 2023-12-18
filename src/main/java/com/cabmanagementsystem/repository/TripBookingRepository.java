package com.cabmanagementsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabmanagementsystem.entity.TripBooking;
import com.cabmanagementsystem.util.BookingStatus;
import com.cabmanagementsystem.util.CabType;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {

	  public List<TripBooking>  findAllByBookingStatus(BookingStatus bs);
	  
	  public List<TripBooking>  findAllByCabType(CabType cabType);
	  
	  public List<TripBooking> findAllByOrderByStartDateAsc();
	  
	  @Query("SELECT t FROM TripBooking t WHERE t.customer.userId = ?1")
	  public List<TripBooking> findAllByCustomerById(int id);
	  
	  @Query("SELECT t from TripBooking t WHERE t.customer.userId = ?1 AND t.startDate BETWEEN ?2 AND ?3  ")
	  public List<TripBooking> findAllBookingByCustomerBasedOnDates(Integer customerId, LocalDate fromDate,
			LocalDate toDate);
	  
}
