
package com.cabmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabmanagementsystem.dto.AdminDTO;
import com.cabmanagementsystem.dto.CabDTO;
import com.cabmanagementsystem.dto.CustomerDTO;
import com.cabmanagementsystem.dto.DriverDTO;
import com.cabmanagementsystem.entity.Admin;
import com.cabmanagementsystem.entity.Cab;
import com.cabmanagementsystem.entity.Customer;
import com.cabmanagementsystem.entity.Driver;
import com.cabmanagementsystem.exception.AdminNotFoundException;
import com.cabmanagementsystem.exception.CabNotFoundException;
import com.cabmanagementsystem.exception.CustomerNotFoundException;
import com.cabmanagementsystem.exception.DriverNotFoundException;
import com.cabmanagementsystem.exception.IdAlreadyExists;
import com.cabmanagementsystem.repository.AdminRepository;
import com.cabmanagementsystem.repository.CabRepository;
import com.cabmanagementsystem.repository.CustomerRepository;
import com.cabmanagementsystem.repository.DriverRepository;

@Service

public class AdminService implements IAdminService {

	@Autowired
	private DriverRepository driverRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CabRepository cabRepo;

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private ModelMapper modelMapper;

	// Method for adding the Admin data

	@Override
	public AdminDTO registerAdmin(AdminDTO adminDTO) {

		// DTO to DAO

		Admin adminDAO = modelMapper.map(adminDTO, Admin.class);
      if(adminRepo.existsById(adminDTO.getUserId()))
    	    throw new IdAlreadyExists("Admin Id already exists");
		adminDAO = adminRepo.save(adminDAO);

		// DAO to DTO

		AdminDTO adminDTO1 = modelMapper.map(adminDAO, AdminDTO.class);

		return adminDTO1;

	}

	// Method for updating the Admin data

	// update Admin details to the database

	@Override

	public AdminDTO updateAdmin(AdminDTO adminDTO) {

		// DTO to DAO

		Admin adminDAO = modelMapper.map(adminDTO, Admin.class);

		if (!adminRepo.existsById(adminDAO.getUserId()))

		{

			throw new AdminNotFoundException("Id not found");

		}

		else

		{

			adminDAO = adminRepo.save(adminDAO);

		}

		// DAO to DTO

		AdminDTO adminDTO1 = modelMapper.map(adminDAO, AdminDTO.class);

		return adminDTO1;

	}

	@Override

	public List<AdminDTO> viewAdmins() {

		List<Admin> adminDAOList = adminRepo.findAll();

		// Empty List

		List<AdminDTO> adminDTOList = new ArrayList<>();

		AdminDTO adminDTO;

		for (int i = 0; i < adminDAOList.size(); i++)

		{

			adminDTO = modelMapper.map(adminDAOList.get(i), AdminDTO.class);// fetching list from database

			adminDTOList.add(adminDTO);

		}

		return adminDTOList;

	}

	@Override

	public AdminDTO viewAdminById(int userId) {

		Admin adminDAO;

		if (!adminRepo.existsById(userId))

		{

			throw new AdminNotFoundException("Admin by Id not found");

		}

		else

		{

			adminDAO = adminRepo.findById(userId).get();

		}

		// DAO to DTO

		AdminDTO adminDTO1 = modelMapper.map(adminDAO, AdminDTO.class);

		return adminDTO1;

	}

	@Override

	public CustomerDTO customerUpdate(int userId, CustomerDTO customerDTO) {

		// DTO to DAO

		Customer CustomerDAO = modelMapper.map(customerDTO, Customer.class);

		if (!customerRepo.existsById(userId)) {

			throw new CustomerNotFoundException("Customer with Id not found");

		}

		else

		{

			CustomerDAO = customerRepo.save(CustomerDAO);

		}

		// DAO to DTO

		CustomerDTO customerDTO1 = modelMapper.map(CustomerDAO, CustomerDTO.class);

		return customerDTO1;

	}

	@Override

	public DriverDTO driverUpdate(int userId, DriverDTO driverDTO) {

		// DTO to DAO

		Driver DriverDAO = modelMapper.map(driverDTO, Driver.class);

		if (!driverRepo.existsById(userId)) {

			throw new DriverNotFoundException("Driver with Id not found");

		}

		else

		{

			DriverDAO = driverRepo.save(DriverDAO);

		}

		// DAO to DTO

		DriverDTO DriverDTO1 = modelMapper.map(DriverDAO, DriverDTO.class);

		return DriverDTO1;

	}

	@Override
	public CabDTO cabUpdate(int cabId, CabDTO cabDTO) {

		// DTO to DAO
		Cab cabDAO = modelMapper.map(cabDTO, Cab.class);
		if (cabRepo.existsById(cabId)) {

			cabDAO = cabRepo.save(cabDAO);
		} else {
			throw new CabNotFoundException("Cab id doesn't exist");
		}
		// DAO to DTO
		CabDTO cabDTO1 = modelMapper.map(cabDAO, CabDTO.class);
		return cabDTO1;
	}

}
