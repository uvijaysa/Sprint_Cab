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
import com.cabmanagementsystem.dto.DriverDTO;
import com.cabmanagementsystem.service.DriverService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService dservice;
    @PostMapping("/add")
    public DriverDTO addDriver(@Valid @RequestBody DriverDTO DTO) {
        return dservice.addDriver(DTO);
    }
    @PutMapping("/update")
    public DriverDTO updateDriver(@Valid @RequestBody DriverDTO DTO) {
        return dservice.updateDriver(DTO);
    }
    @GetMapping("/getAll")
    public List < DriverDTO > viewDrivers() {
        return dservice.viewDrivers();
    }
    @GetMapping("/getDriverById/{driverId}")
    public DriverDTO viewDriverById(@PathVariable("driverId") int driverId) {
        return dservice.viewDriverById(driverId);
    }
    @GetMapping("/getAllDriversAvailability")
    public List < DriverDTO > viewDriverByAvailability() {
        return dservice.viewDriverByAvailability();
    }
}