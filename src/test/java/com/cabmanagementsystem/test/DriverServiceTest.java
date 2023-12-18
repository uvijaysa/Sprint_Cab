package com.cabmanagementsystem.test;


 
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.eq;

import static org.mockito.Mockito.times;

import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;
 
import java.util.ArrayList;

import java.util.List;
 
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import org.modelmapper.ModelMapper;
 
import com.cabmanagementsystem.dto.DriverDTO;

import com.cabmanagementsystem.entity.Driver;

import com.cabmanagementsystem.repository.DriverRepository;

import com.cabmanagementsystem.service.DriverService;
 
@ExtendWith(MockitoExtension.class)

public class DriverServiceTest {
 
		@Mock

		private DriverRepository driverRepository;

		@InjectMocks

		private DriverService driverService;

		@Mock

		private ModelMapper modelMapper;

		@Test

	    void addDriver() 

		{

	       // Arrange

	       DriverDTO driverDTO = new DriverDTO();

	       Driver driverEntity = new Driver();

	       when(modelMapper.map(driverDTO, Driver.class)).thenReturn(driverEntity);

	       when(driverRepository.save(driverEntity)).thenReturn(driverEntity);

	       when(modelMapper.map(driverEntity, DriverDTO.class)).thenReturn(driverDTO);

	       // Act

	       DriverDTO result = driverService.addDriver(driverDTO);

	       // Assert

	       assertNotNull(result);

	     assertEquals(driverDTO.getUserId(), result.getUserId());

	     assertEquals(driverDTO.getDriverName(), result.getDriverName());

	     assertEquals(driverDTO.getUserName(), result.getUserName());

	     assertEquals(driverDTO.getAddress(), result.getAddress());

	     assertEquals(driverDTO.getMobileNumber(), result.getMobileNumber());

	     assertEquals(driverDTO.getPassword(), result.getPassword());

	     assertEquals(driverDTO.getEmail(), result.getEmail());

	     assertEquals(driverDTO.getLicenseNo(), result.getLicenseNo());

	     assertEquals(driverDTO.getDriverAvailability(), result.getDriverAvailability());

	}

		@Test

		void testViewDrivers() {

			// Arrange

			List<Driver> driverEntities = new ArrayList<>();

			driverEntities.add(new Driver());

			when(driverRepository.findAll()).thenReturn(driverEntities);

			// Act

			List<DriverDTO> result = driverService.viewDrivers();

			// Assert

			assertEquals(driverEntities.size(), result.size());

			verify(driverRepository).findAll();

			verify(modelMapper, times(driverEntities.size())).map(any(), eq(DriverDTO.class));

		}

		@Test

		void testViewDriverById() {

			// Arrange

			int driverId = 1;

			Driver driverEntity = new Driver();

			when(driverRepository.findById(driverId)).thenReturn(java.util.Optional.of(driverEntity));

			// Act

			DriverDTO result = driverService.viewDriverById(driverId);

			// Assert

			verify(driverRepository).findById(driverId);

			verify(modelMapper).map(driverEntity, DriverDTO.class);

		}

		@Test

		void testViewDriverByAvailability() {

			// Arrange

			List<Driver> driverEntities = new ArrayList<>();

			driverEntities.add(new Driver());

			when(driverRepository.findAllByDriverAvailabilityTrue()).thenReturn(driverEntities);

			// Act

			List<DriverDTO> result = driverService.viewDriverByAvailability();

			// Assert

			assertEquals(driverEntities.size(), result.size());

			verify(driverRepository).findAllByDriverAvailabilityTrue();

			verify(modelMapper, times(driverEntities.size())).map(any(), eq(DriverDTO.class));

		}

 
}
