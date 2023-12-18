package com.cabmanagementsystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import com.cabmanagementsystem.dto.TripBookingDTO;
import com.cabmanagementsystem.entity.TripBooking;
import com.cabmanagementsystem.repository.TripBookingRepository;
import com.cabmanagementsystem.service.TripBookingService;
import com.cabmanagementsystem.util.CabType;

@ExtendWith(MockitoExtension.class)
public class TripBookingServiceTest {
	@InjectMocks
	private TripBookingService tripBookingService;
	@Mock
	private TripBookingRepository tripBookingRepository;
	@Mock
	private ModelMapper modelMapper;

	@Test
	void testViewBookingByCustomerId() {
		TripBooking tripBookingEntity1 = new TripBooking();
		TripBooking tripBookingEntity2 = new TripBooking();
		int customerId = 1;
		List<TripBooking> tripBookingEntityList = Arrays.asList(tripBookingEntity1, tripBookingEntity2);
		when(tripBookingRepository.findAllByCustomerById(customerId)).thenReturn(tripBookingEntityList);
		when(modelMapper.map(any(), eq(TripBookingDTO.class))).thenReturn(new TripBookingDTO());
		List<TripBookingDTO> tripBookingDTOList = tripBookingService.viewBookingByCustomerId(customerId);
		verify(tripBookingRepository, times(1)).findAllByCustomerById(customerId);
		verify(modelMapper, times(2)).map(any(), eq(TripBookingDTO.class));
		assertNotNull(tripBookingDTOList);
		assertEquals(2, tripBookingDTOList.size());
	}

	@Test
	void testViewBookingByCabType() {
		TripBooking tripBookingEntity1 = new TripBooking();
		TripBooking tripBookingEntity2 = new TripBooking();
		String cabType = "SEDAN";
		List<TripBooking> tripBookingEntityList = Arrays.asList(tripBookingEntity1, tripBookingEntity2);
		when(tripBookingRepository.findAllByCabType(CabType.valueOf(cabType))).thenReturn(tripBookingEntityList);
		when(modelMapper.map(any(), eq(TripBookingDTO.class))).thenReturn(new TripBookingDTO());
		List<TripBookingDTO> tripBookingDTOList = tripBookingService.viewBookingByCabType(cabType);
		verify(tripBookingRepository, times(1)).findAllByCabType(CabType.valueOf(cabType));
		verify(modelMapper, times(2)).map(any(), eq(TripBookingDTO.class));
		assertNotNull(tripBookingDTOList);
		assertEquals(2, tripBookingDTOList.size());
	}

	@Test
	void testViewBookingsByCustomerBasedOnDates() {
		TripBooking tripBookingEntity1 = new TripBooking();
		TripBooking tripBookingEntity2 = new TripBooking();
		int customerId = 1;
		LocalDate fromDate = LocalDate.now();
		LocalDate toDate = LocalDate.now().plusDays(7);
		List<TripBooking> tripBookingEntityList = Arrays.asList(tripBookingEntity1, tripBookingEntity2);
		when(tripBookingRepository.findAllBookingByCustomerBasedOnDates(customerId, fromDate, toDate))
				.thenReturn(tripBookingEntityList);
		when(modelMapper.map(any(), eq(TripBookingDTO.class))).thenReturn(new TripBookingDTO());
		List<TripBookingDTO> tripBookingDTOList = tripBookingService.viewBookingsByCustomerBasedOnDates(customerId,
				fromDate, toDate);
		verify(tripBookingRepository, times(1)).findAllBookingByCustomerBasedOnDates(customerId, fromDate, toDate);
		verify(modelMapper, times(2)).map(any(), eq(TripBookingDTO.class));
		assertNotNull(tripBookingDTOList);
		assertEquals(2, tripBookingDTOList.size());
	}
}