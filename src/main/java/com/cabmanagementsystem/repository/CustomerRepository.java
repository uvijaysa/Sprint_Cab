package com.cabmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabmanagementsystem.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	public Customer findByUserName(String userName);

	public boolean existsByUserName(String userName);
	

}
