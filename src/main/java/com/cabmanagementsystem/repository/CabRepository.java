
package com.cabmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.cabmanagementsystem.entity.Cab;

import com.cabmanagementsystem.entity.Driver;

import com.cabmanagementsystem.util.CabType;




public interface CabRepository extends JpaRepository<Cab, Integer> {

	public List<Cab> findAllByCabType(CabType CabType);

	public List<Cab> findAllByCurrentLocation(String currentLocation);

	public List<Cab> findAllByCabTypeAndCurrentLocation(CabType cabType, String currentLocation);

	public List<Cab> findAllByCabAvailabilityTrue();

	public Cab findByDriver(Driver driverId);

	@Query("SELECT c FROM Cab c WHERE c.driver.userId = ?1")
	public Cab findCabByDriverId(int id);

}
