package com.cabmanagementsystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cabmanagementsystem.entity.Customer;
import com.cabmanagementsystem.repository.CustomerRepository;

@Service
public class CustomerAuthenticationService {
    @Autowired
    private CustomerRepository cRepo;
    private boolean flag = false;
    public String customerLogin(String userName, String password) {
        Customer c = cRepo.findByUserName(userName);
        if (cRepo.existsByUserName(userName)) {
            if (c.getPassword().equals(password)) {
                flag = true;
                return "Customer Logged In Successfully";
            } else
                return "Password Incorrect";
        } else {
            return "Customer Not Found";
        }
    }
    public String customerLogout() {
        if (flag) {
            flag = false;
            return "Customer  logged out successfully";
        } else
            return "Customer already logged out";
    }
}