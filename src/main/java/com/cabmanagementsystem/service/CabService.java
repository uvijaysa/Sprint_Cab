package com.cabmanagementsystem.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabmanagementsystem.dto.CabDTO;
import com.cabmanagementsystem.entity.Cab;
import com.cabmanagementsystem.exception.CabNotFoundException;
import com.cabmanagementsystem.exception.IdAlreadyExists;
import com.cabmanagementsystem.repository.CabRepository;
import com.cabmanagementsystem.util.CabType;

@Service
public class CabService implements ICabService {
    @Autowired
    private CabRepository cabRepo;
    @Autowired
    private ModelMapper modelMapper;
    

    
    @Override
    public CabDTO addCab(CabDTO cabDTO) {
    	if(cabRepo.existsById(cabDTO.getCabId()))
    		   throw new IdAlreadyExists("Id Already Exists");
        // DTO to DAO
        Cab cabDAO = modelMapper.map(cabDTO, Cab.class);
        cabDAO = cabRepo.save(cabDAO);
        // DAO to DTO
        CabDTO cabDTO1 = modelMapper.map(cabDAO, CabDTO.class);
        return cabDTO1;
    }
    @Override
    public CabDTO updateCab(CabDTO cabDTO) {
    	
        // DTO to DAO
        Cab cabDAO = modelMapper.map(cabDTO, Cab.class);
        if (cabRepo.existsById(cabDAO.getCabId())) {
        	
            cabDAO = cabRepo.save(cabDAO);
        }
        else
        {
        	  throw new CabNotFoundException("Cab id doesn't exist");
        }
        // DAO to DTO
        CabDTO cabDTO1 = modelMapper.map(cabDAO, CabDTO.class);
        return cabDTO1;
    }
    @Override
    public List < CabDTO > viewCabs() {
        List < Cab > cabDAOList = cabRepo.findAll();
        List < CabDTO > cabDTOList = new ArrayList();
        for (int i = 0; i < cabDAOList.size(); i++) {
            cabDTOList.add(modelMapper.map(cabDAOList.get(i), CabDTO.class));
        }
        return cabDTOList;
    }
    @Override
    public List < CabDTO > viewCabByType(String cabType) {
        List < Cab > cabDAO = cabRepo.findAllByCabType(CabType.valueOf(cabType));
        if(cabDAO.size() ==0)
      	  throw new CabNotFoundException("Cabs not found based on given cab type");

        List < CabDTO > cabDTOList = new ArrayList < > ();
        for (int i = 0; i < cabDAO.size(); i++) {
            cabDTOList.add(modelMapper.map(cabDAO.get(i), CabDTO.class));
        }
        return cabDTOList;
    }
    @Override
    public List < CabDTO > viewCabByCurrentLocation(String currentLocation) {
        List < Cab > cabDAO = cabRepo.findAllByCurrentLocation(currentLocation);
        if(cabDAO.size() ==0)
        	  throw new CabNotFoundException("Cabs not found based on given location");
        List < CabDTO > cabDTOList = new ArrayList < > ();
        for (int i = 0; i < cabDAO.size(); i++) {
            cabDTOList.add(modelMapper.map(cabDAO.get(i), CabDTO.class));
        }
        return cabDTOList;
    }
    @Override
    public CabDTO viewCabByDriverId(int driverId) {
        Cab cabDAO = cabRepo.findCabByDriverId(driverId);
        if(cabDAO==null) {
            throw new CabNotFoundException("driver details doesn't exists");
        }
        CabDTO cabDTO = modelMapper.map(cabDAO, CabDTO.class);
        return cabDTO;
    }
    @Override
    public CabDTO viewCabById(int cabId) {
        Optional<Cab> cabDAO = cabRepo.findById(cabId);
        if(cabDAO.isEmpty()) {
            throw new CabNotFoundException("Cab not found exception by given id");
        }
        CabDTO cabDTO = modelMapper.map(cabDAO, CabDTO.class);
        return cabDTO;
    }
    @Override
    public List < CabDTO > viewCabByTypeAndLocation(String cabType, String currentLocation) {
        List < Cab > cabDAO = cabRepo.findAllByCabTypeAndCurrentLocation(CabType.valueOf(cabType), currentLocation);
        if(cabDAO.size()==0) {
            throw new CabNotFoundException("Cab details not found on given cab type and location");
        }
        List < CabDTO > cabDTOList = new ArrayList < > ();
        for (int i = 0; i < cabDAO.size(); i++) {
            cabDTOList.add(modelMapper.map(cabDAO.get(i), CabDTO.class));
        }
        return cabDTOList;
    }
    @Override
    public List < CabDTO > viewCabByAvailability() {
        List < Cab > cabDAO = cabRepo.findAllByCabAvailabilityTrue();
        List < CabDTO > cabDTOList = new ArrayList < > ();
        for (int i = 0; i < cabDAO.size(); i++) {
            cabDTOList.add(modelMapper.map(cabDAO.get(i), CabDTO.class));
        }
        return cabDTOList;
    }
}