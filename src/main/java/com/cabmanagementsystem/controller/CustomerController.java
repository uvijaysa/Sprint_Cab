package com.cabmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabmanagementsystem.dto.CustomerDTO;
import com.cabmanagementsystem.exception.CustomerNotFoundException;
import com.cabmanagementsystem.service.CustomerService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired

    private CustomerService cService;


    @PostMapping("/add")

    public CustomerDTO registerCustomer(@Valid @RequestBody CustomerDTO customer) {


        return cService.registerCustomer(customer);

    }

    @PutMapping("/update")

    public CustomerDTO updateCustomer(@Valid @RequestBody CustomerDTO customer) {

        return cService.updateCustomer(customer);

    }

    @GetMapping("/getAll")

    public List < CustomerDTO > viewCustomers() {

        return cService.viewCustomers();

    }

    @GetMapping("/viewCustomerById/{id}")

    public CustomerDTO viewCustomerById(@PathVariable("id") Integer id)  {

        return cService.viewCustomerById(id);

    }


}