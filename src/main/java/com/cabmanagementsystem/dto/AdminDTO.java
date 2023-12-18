package com.cabmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AdminDTO extends UserDTO{

	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain letters")
	@NotBlank(message = "Admin Name cannot be blank")
	private String adminName;

	public AdminDTO() {
		super();
	}
	public AdminDTO(int userId, String userName, String password, String address, String mobileNumber, String email,
			 String adminName) {
		super(userId, userName, password, address, mobileNumber, email);
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "AdminDTO [adminName=" + adminName + "]";
	}
	
	
}