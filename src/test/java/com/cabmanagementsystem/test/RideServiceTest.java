package com.cabmanagementsystem.test;


 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.cabmanagementsystem.dto.RideDTO;
import com.cabmanagementsystem.entity.Ride;
import com.cabmanagementsystem.repository.RideRepository;
import com.cabmanagementsystem.service.RideService;
import com.cabmanagementsystem.util.RideStatus;
 
@ExtendWith(MockitoExtension.class)

public class RideServiceTest {
 
	

	@InjectMocks

    private RideService rideService;
 
    @Mock

    private RideRepository rideRepository;
 
    @Mock

    private ModelMapper modelMapper;
 
    

    @Test

    void testAddRide() {

        RideDTO rideDTO = new RideDTO();

        Ride rideEntity = new Ride();

        // Mock the modelMapper

        when(modelMapper.map(rideDTO, Ride.class)).thenReturn(rideEntity);

        lenient().when(modelMapper.map(any(), eq(RideDTO.class))).thenReturn(new RideDTO());

        // Mock the repository save method

        when(rideRepository.save(any())).thenReturn(rideEntity);

        RideDTO savedRide = rideService.addRide(rideDTO);
 
        verify(modelMapper, times(1)).map(rideDTO, Ride.class);

        verify(rideRepository, times(1)).save(any());

        assertNotNull(savedRide);

        assertEquals(rideDTO.getRideId(), savedRide.getRideId());

    }
    
    @Test
    void testViewRidesByStatus() 
    {
    	Ride rideEntity1 = new Ride();
    	Ride rideEntity2 = new Ride();
        String status = "ONGOING";
        List<Ride> rideEntityList = Arrays.asList(rideEntity1, rideEntity2);
        when(rideRepository.findAllByRideStatus(RideStatus.ONGOING)).thenReturn(rideEntityList);
        when(modelMapper.map(any(), eq(RideDTO.class))).thenReturn(new RideDTO());
 
        List<RideDTO> rideDTOList = rideService.viewRideByStatus(status);
 
        verify(rideRepository, times(1)).findAllByRideStatus(RideStatus.ONGOING);
        verify(modelMapper, times(2)).map(any(), eq(RideDTO.class));
 
        assertNotNull(rideDTOList);
        assertEquals(2, rideDTOList.size());
    }
    
}
