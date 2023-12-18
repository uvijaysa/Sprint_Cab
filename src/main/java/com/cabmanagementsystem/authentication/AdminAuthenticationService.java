package com.cabmanagementsystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cabmanagementsystem.entity.Admin;
import com.cabmanagementsystem.repository.AdminRepository;


@Service
public class AdminAuthenticationService {
    @Autowired
    private AdminRepository adminRepo;
    private boolean flag = false;
    public String adminLogin(String userName, String password) {
        Admin a = adminRepo.findByUserName(userName);
        if (adminRepo.existsByUserName(userName)) {
            if (a.getPassword().equals(password)) {
                flag = true;
                return "Admin Logged In Successfully";
            } else {
                return "Password Incorrect";
            }
        } else {
            return "Admin Not Found";
        }
    }
    public String adminLogout() {
        if (flag) {
            flag = false;
            return "Admin logged out successfully";
        } else {
            return "Admin already logged out";
        }
    }
}