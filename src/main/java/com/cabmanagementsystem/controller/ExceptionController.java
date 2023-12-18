
package com.cabmanagementsystem.controller;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cabmanagementsystem.exception.AdminNotFoundException;
import com.cabmanagementsystem.exception.CabNotFoundException;
import com.cabmanagementsystem.exception.CustomerNotFoundException;
import com.cabmanagementsystem.exception.DriverNotFoundException;
import com.cabmanagementsystem.exception.IdAlreadyExists;
import com.cabmanagementsystem.exception.RideNotFoundException;
import com.cabmanagementsystem.exception.TripBookingNotFoundException;
 
@ControllerAdvice

public class ExceptionController {

	@ExceptionHandler(value=CustomerNotFoundException.class)

	public ResponseEntity<Object> exceptionMethod(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
 
	@ExceptionHandler(value=CabNotFoundException.class)

	public ResponseEntity<Object> exceptionMethodCab(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(value=DriverNotFoundException.class)

	public ResponseEntity<Object> exceptionMethodDriver(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(value=RideNotFoundException.class)

	public ResponseEntity<Object> exceptionMethodRide(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value=TripBookingNotFoundException.class)

	public ResponseEntity<Object> exceptionMethodRideTrip(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value=IdAlreadyExists.class)

	public ResponseEntity<Object> exceptionMethodId(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value=AdminNotFoundException.class)

	public ResponseEntity<Object> exceptionMethodAdmin(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
	
	
	
}
