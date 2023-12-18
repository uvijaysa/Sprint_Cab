
package com.cabmanagementsystem.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cabmanagementsystem.entity.Ride;

import com.cabmanagementsystem.util.RideStatus;

@Repository

public interface RideRepository extends JpaRepository<Ride, Integer> {

	@Query("SELECT r FROM Ride r WHERE r.customer.userId = ?1")

	public List<Ride> findAllByCustomerId(int customerId);

	@Query("select r from Ride r where r.cab.cabId=?1")

	public List<Ride> findAllByCabId(int cabId);

	@Query("select r from Ride r where cab.driver.userId=?1")

	public List<Ride> findAllByDriverId(int driverId);

	public List<Ride> findAllByRideStatus(RideStatus ride);

	public List<Ride> findAllByDate(LocalDate date);

}