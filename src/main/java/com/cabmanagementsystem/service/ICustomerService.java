package com.cabmanagementsystem.service;

import java.util.List;

import com.cabmanagementsystem.dto.CustomerDTO;
import com.cabmanagementsystem.exception.CustomerNotFoundException;

public interface ICustomerService {

    public CustomerDTO registerCustomer(CustomerDTO customer);
    public CustomerDTO updateCustomer(CustomerDTO customer);
    public List < CustomerDTO > viewCustomers();
    public CustomerDTO viewCustomerById(Integer customerId) throws CustomerNotFoundException;

 }