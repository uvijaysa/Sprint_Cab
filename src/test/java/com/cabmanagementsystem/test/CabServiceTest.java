package com.cabmanagementsystem.test;



 
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.when;
 
import java.util.Arrays;

import java.util.List;
 
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import org.modelmapper.ModelMapper;
 
import com.cabmanagementsystem.dto.CabDTO;

import com.cabmanagementsystem.entity.Cab;

import com.cabmanagementsystem.repository.CabRepository;

import com.cabmanagementsystem.service.CabService;
 
@ExtendWith(MockitoExtension.class)
public class CabServiceTest {
 
	

	@InjectMocks

    private CabService cabService;

    @Mock

    private CabRepository cabRepository;

    @Mock

    private ModelMapper modelMapper;



    @Test

	void addCab() {

		// Arrange

		CabDTO cabDTO = new CabDTO();

		Cab cabEntity = new Cab();

		when(modelMapper.map(cabDTO, Cab.class)).thenReturn(cabEntity);

		when(cabRepository.save(cabEntity)).thenReturn(cabEntity);

		when(modelMapper.map(cabEntity, CabDTO.class)).thenReturn(cabDTO);

		// Act

		CabDTO result = cabService.addCab(cabDTO);

		//

		// Assert

		assertNotNull(result);

		assertEquals(cabDTO.getCabId(), result.getCabId());

		assertEquals(cabDTO.getCabType(), result.getCabType());

		assertEquals(cabDTO.getCurrentLocation(),result.getCurrentLocation());

		assertEquals(cabDTO.getDriver(), result.getDriver());

		assertEquals(cabDTO.getRatePerKm(), result.getRatePerKm());

		assertEquals(cabDTO.getRegistrationNo(), result.getRegistrationNo());

		assertEquals(cabDTO.getCabAvailability(), result.getCabAvailability());
 


	}


    @Test

    public void testViewCabs() {

        // Arrange

        Cab cab1 = new Cab();

        Cab cab2 = new Cab();

        List<Cab> cabEntities = Arrays.asList(cab1, cab2);

        when(cabRepository.findAll()).thenReturn(cabEntities);

        // Act

        List<CabDTO> result = cabService.viewCabs();

        // Assert

        assertEquals(cabEntities.size(), result.size());

       

    }
 
}
