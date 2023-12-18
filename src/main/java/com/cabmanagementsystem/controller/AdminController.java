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
import com.cabmanagementsystem.dto.AdminDTO;
import com.cabmanagementsystem.dto.CabDTO;
import com.cabmanagementsystem.dto.CustomerDTO;
import com.cabmanagementsystem.dto.DriverDTO;
import com.cabmanagementsystem.service.AdminService;
import com.cabmanagementsystem.service.CabService;
import com.cabmanagementsystem.service.CustomerService;
import com.cabmanagementsystem.service.DriverService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private CabService cabService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private AdminService adminService;
    @PostMapping("/addAdmin")
    public AdminDTO adminRegistration(@Valid @RequestBody AdminDTO adminObj) {
        return adminService.registerAdmin(adminObj);
    }
    @PutMapping("/updateAdmin")
    public AdminDTO adminUpdate(@RequestBody AdminDTO adminObj) {
        return adminService.updateAdmin(adminObj);
    }
    @GetMapping("/getAdmins")
    public List < AdminDTO > getAdmins() {
        return adminService.viewAdmins();
    }
    @GetMapping("/getAdminById/{userId}")
    public AdminDTO adminById(@PathVariable("userId") int userId) {
        return adminService.viewAdminById(userId);
    }
    @PutMapping("/customerUpdate/{userId}")
    public CustomerDTO customerUpdate(@PathVariable("userId") int userId, @Valid @RequestBody CustomerDTO customerObj) {
        return adminService.customerUpdate(userId, customerObj);
    }
    @PutMapping("/driverUpdate/{userId}")
    public DriverDTO driverUpdate(@PathVariable("userId") int userId, @Valid @RequestBody DriverDTO driverObj) {
        return adminService.driverUpdate(userId, driverObj);
    }
    @PutMapping("/cabUpdate/{cabId}")
    public CabDTO cabUpdate(@PathVariable("cabId") int cabId, @Valid @RequestBody CabDTO cabObj) {
        return adminService.cabUpdate(cabId, cabObj);
    }
}