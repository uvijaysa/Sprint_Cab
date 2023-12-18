package com.cabmanagementsystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cabmanagementsystem.entity.Driver;
import com.cabmanagementsystem.repository.DriverRepository;

@Service
public class DriverAuthenticationService {
    @Autowired
    private DriverRepository driverRepo;
    private boolean flag = false;
    public String DriverLogin(String userName, String password) {
        Driver d = driverRepo.findByUserName(userName);
        if (driverRepo.existsByUserName(userName)) {
            if (d.getPassword().equals(password)) {
                flag = true;
                return "Driver Logged In Successfully";
            } else {
                return "Password Incorrect";
            }
        } else {
            return "Driver Not Found";
        }
    }
    public String driverLogout() {
        if (flag) {
            flag = false;
            return "Driver logged out successfully";
        } else {
            return "Driver already logged out";
        }
    }
}