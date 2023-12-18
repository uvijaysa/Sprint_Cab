package com.cabmanagementsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabmanagementsystem.dto.TripBookingDTO;
import com.cabmanagementsystem.entity.TripBooking;
import com.cabmanagementsystem.exception.BookingStatusNotFound;
import com.cabmanagementsystem.exception.IdAlreadyExists;
import com.cabmanagementsystem.exception.TripBookingNotFoundException;
import com.cabmanagementsystem.repository.TripBookingRepository;
import com.cabmanagementsystem.util.BookingStatus;
import com.cabmanagementsystem.util.CabType;

@Service
public class TripBookingService implements ITripBookingService {

	@Autowired
	private TripBookingRepository tripRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TripBookingDTO addTripBooking(TripBookingDTO tripBookingDTO) {
		TripBooking tripBookingDAO = modelMapper.map(tripBookingDTO, TripBooking.class); // DTO to DAO
		  if(tripRepo.existsById(tripBookingDTO.getTripBookingId()))
	   		   throw new IdAlreadyExists("Id Already Exists");
		tripBookingDAO = tripRepo.save(tripBookingDAO);
		TripBookingDTO tripBookingDTO1 = modelMapper.map(tripBookingDAO, TripBookingDTO.class); // DAO to DTO
		return tripBookingDTO1;
	}

	@Override
	public TripBookingDTO updateTripBooking(TripBookingDTO tripBookingDTO) {
		TripBooking tripBookingDAO = modelMapper.map(tripBookingDTO, TripBooking.class);
		if (tripRepo.existsById(tripBookingDAO.getTripBookingId())) {
			tripBookingDAO = tripRepo.save(tripBookingDAO);
		}else
		{
			   throw new TripBookingNotFoundException("Trip Booking id doesn't exists");
		}
		TripBookingDTO tripBookingDTO1 = modelMapper.map(tripBookingDAO, TripBookingDTO.class); // DAO to DTO
		return tripBookingDTO1;
	}

	@Override
	public TripBookingDTO cancleTripBooking(Integer tripBookingId) {
		// TODO Auto-generated method stub
		Optional<TripBooking> tripBooking = tripRepo.findById(tripBookingId);
		TripBooking tripBookingDAO;
		 if(tripBooking.isEmpty())
		 {
			    throw new  TripBookingNotFoundException("Trip Booking id doesn't exists");
		 }else
		 {
			      tripBookingDAO = tripBooking.get();
		 } 
		tripBookingDAO.setBookingStatus(BookingStatus.CANCELED);
		tripBookingDAO = tripRepo.save(tripBookingDAO);
		return modelMapper.map(tripBookingDAO, TripBookingDTO.class);
	}

	@Override
	public List<TripBookingDTO> viewAllBookings() {
		List<TripBooking> tripBookingDAOList = tripRepo.findAll();
		List<TripBookingDTO> tripBookingDTOList = new ArrayList<>(); // Empty List
		TripBookingDTO tripBookingDTO;
		for (int i = 0; i < tripBookingDAOList.size(); i++) {
			tripBookingDTO = modelMapper.map(tripBookingDAOList.get(i), TripBookingDTO.class);
			tripBookingDTOList.add(tripBookingDTO);
		}
		return tripBookingDTOList;
	}

	@Override
	public TripBookingDTO viewBookingByBookingId(Integer tripBookingId) {
		// TODO Auto-generated method stub
		Optional<TripBooking> tripBooking = tripRepo.findById(tripBookingId);
		TripBooking tripBookingDAO;
		 if(tripBooking.isEmpty())
		 {
			    throw new  TripBookingNotFoundException("Trip Booking id doesn't exists");
		 }else
		 {
			      tripBookingDAO = tripBooking.get();
		 } 
		TripBookingDTO tripBookingDTO = modelMapper.map(tripBookingDAO, TripBookingDTO.class);
		return tripBookingDTO;
	}

	@Override
	public List<TripBookingDTO> viewBookingByCustomerId(Integer customerId) {
		List<TripBooking> tripBookingDAOList = tripRepo.findAllByCustomerById(customerId);
		if(tripBookingDAOList.size() == 0)
                      throw new  TripBookingNotFoundException("Trip Booking details not found of given customer id");
		List<TripBookingDTO> tripBookingDTOList = new ArrayList<>();
		TripBookingDTO tripBookingDTO;
		for (int i = 0; i < tripBookingDAOList.size(); i++) {
			tripBookingDTO = modelMapper.map(tripBookingDAOList.get(i), TripBookingDTO.class);
			tripBookingDTOList.add(tripBookingDTO);
		}
		return tripBookingDTOList;
	}

	@Override
	public List<TripBookingDTO> viewBookingByBookingStatus(String status) {
		List<TripBooking> tripBookingDAOList = tripRepo.findAllByBookingStatus(BookingStatus.valueOf(status));
		if(tripBookingDAOList.size() == 0)
        throw new  TripBookingNotFoundException("Trip Booking details not found of given booking status");
		List<TripBookingDTO> tripBookingDTOList = new ArrayList<>(); // Empty List
		for (int i = 0; i < tripBookingDAOList.size(); i++) {
			tripBookingDTOList.add(modelMapper.map(tripBookingDAOList.get(i), TripBookingDTO.class));
		}
		return tripBookingDTOList;
	}

	@Override
	public List<TripBookingDTO> viewBookingByCabType(String cabType) {
		List<TripBooking> tripBookingDAOList = tripRepo.findAllByCabType(CabType.valueOf(cabType));
		if(tripBookingDAOList.size() == 0)
        throw new  TripBookingNotFoundException("Trip Booking details not found of given cab type");
		List<TripBookingDTO> tripBookingDTOList = new ArrayList<>(); // Empty List
		for (int i = 0; i < tripBookingDAOList.size(); i++) {
			tripBookingDTOList.add(modelMapper.map(tripBookingDAOList.get(i), TripBookingDTO.class));
		}
		return tripBookingDTOList;
	}

	@Override
	public List<TripBookingDTO> viewBookingsByDatewiseSortingOrder() {
		List<TripBooking> tripBookingDAOList = tripRepo.findAllByOrderByStartDateAsc();
		
		List<TripBookingDTO> tripBookingDTOList = new ArrayList<>(); // Empty List
		for (int i = 0; i < tripBookingDAOList.size(); i++) {
			tripBookingDTOList.add(modelMapper.map(tripBookingDAOList.get(i), TripBookingDTO.class));
		}
		return tripBookingDTOList;
	}

	@Override
	public List<TripBookingDTO> viewBookingsByCustomerBasedOnDates(Integer customerId, LocalDate fromDate,
			LocalDate toDate) {
		System.out.println("Enter");
		List<TripBooking> tripBookingDAOList = tripRepo.findAllBookingByCustomerBasedOnDates(customerId, fromDate, toDate);
		if(tripBookingDAOList.size() == 0)
        throw new  TripBookingNotFoundException("Trip Booking details not found of given customer between given dates");
		List<TripBookingDTO> tripBookingDTOList = new ArrayList<>(); // Empty List
		for (int i = 0; i < tripBookingDAOList.size(); i++) {
			tripBookingDTOList.add(modelMapper.map(tripBookingDAOList.get(i), TripBookingDTO.class));
			System.out.println("Size : " + tripBookingDTOList.size());
		}
		return tripBookingDTOList;
	}

}