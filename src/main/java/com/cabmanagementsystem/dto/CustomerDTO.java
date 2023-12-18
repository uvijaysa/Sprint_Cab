package com.cabmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerDTO extends UserDTO{
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain letters")

	@NotBlank(message="Name should not be null")
	private String customerName;

	public CustomerDTO() {
		super();
	}
	public CustomerDTO(int userId, String userName, String password, String address, String mobileNumber, String email,
			 String customerName) {
		super(userId, userName, password, address, mobileNumber, email);
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	public String toString() {
		return "CustomerDTO [customerName=" + customerName + "]";
	}			

}