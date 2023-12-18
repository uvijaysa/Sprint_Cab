package com.cabmanagementsystem.service;

import java.util.List;

import com.cabmanagementsystem.dto.AdminDTO;

import com.cabmanagementsystem.dto.CabDTO;

import com.cabmanagementsystem.dto.CustomerDTO;

import com.cabmanagementsystem.dto.DriverDTO;

public interface IAdminService {

	public AdminDTO registerAdmin(AdminDTO adminDTO);

	public AdminDTO updateAdmin(AdminDTO adminDTO);

	public List<AdminDTO> viewAdmins();

	public AdminDTO viewAdminById(int adminId);

	public CustomerDTO customerUpdate(int userId, CustomerDTO customerDto);

	public DriverDTO driverUpdate(int userId, DriverDTO driverDto);

	public CabDTO cabUpdate(int cabId, CabDTO cabDto);

}
