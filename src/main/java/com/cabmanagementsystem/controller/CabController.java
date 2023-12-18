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

import com.cabmanagementsystem.dto.CabDTO;
import com.cabmanagementsystem.service.CabService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cab")
public class CabController {
	
	@Autowired
	private CabService cabService;
	
	@PostMapping("/add")
	public CabDTO addCab(@Valid @RequestBody CabDTO c)
	{
		 return cabService.addCab(c);
	}
	
	@PutMapping("/update")
	public CabDTO updateCab(@Valid @RequestBody CabDTO c)
	{
		return cabService.updateCab(c);
	}
	
	@GetMapping("/getAll")
	public List<CabDTO> viewCabs()
	{
		return cabService.viewCabs();
	}
	
	@GetMapping("/viewCabType/{cabType}")
	public List<CabDTO> viewCabByType(@PathVariable("cabType") String cabType) 
	{
		return cabService.viewCabByType(cabType);
	}
	
	@GetMapping("/viewByLocation/{currentLocation}")
	public List<CabDTO> viewCabByCurrentLocation(@PathVariable("currentLocation") String currentLocation)
	{
		return cabService.viewCabByCurrentLocation(currentLocation);
	}
	
	@GetMapping("/viewCabById/{cabId}")
	public CabDTO viewCabById(@PathVariable("cabId") int cabId) 
	{
		return cabService.viewCabById(cabId);
	}
	
	@GetMapping("/viewByTypeAndLoc/{cabType}/{currentLocation}")
	public List<CabDTO> viewCabByTypeAndLocation(@PathVariable("cabType") String cabType,@PathVariable("currentLocation") String currentLocation) 
	{
		return cabService.viewCabByTypeAndLocation(cabType, currentLocation);
	}
	
	@GetMapping("/viewCabAvail")
	public List<CabDTO> viewCabByAvailability()
	{
		return cabService.viewCabByAvailability();
	}
	
	@GetMapping("/viewCabByDriverId/{driverId}")
	public CabDTO viewCabByDriverId(@PathVariable("driverId") int driverId)
	{
		return cabService.viewCabByDriverId(driverId);
	}
}

	
