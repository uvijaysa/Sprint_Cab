package com.cabmanagementsystem.test;


 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.cabmanagementsystem.dto.CustomerDTO;
import com.cabmanagementsystem.entity.Customer;
import com.cabmanagementsystem.exception.CustomerNotFoundException;
import com.cabmanagementsystem.repository.CustomerRepository;
import com.cabmanagementsystem.service.CustomerService;
 
@ExtendWith(MockitoExtension.class)

class CustomerServiceTest {

    @Mock

    private CustomerRepository customerRepository;

    @Mock

    private ModelMapper modelMapper;

    @InjectMocks

    private CustomerService customerService;


    @Test

     void testRegisterCustomer() {
 
            // Arrange

            CustomerDTO customerDTO = new CustomerDTO(1,"Allu","Allu@134","Pune","123456789","Allu@gmail.com","Subbu");

            Customer customerEntity = new Customer(1,"Allu","Allu@134","Pune","123456789","Allu@gmail.com","Subbu");
 
            when(modelMapper.map(customerDTO, Customer.class)).thenReturn(customerEntity);

            when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

            when(modelMapper.map(customerEntity, CustomerDTO.class)).thenReturn(customerDTO);
 
            // Act

            CustomerDTO result = customerService.registerCustomer(customerDTO);
 
            // Assert

          assertNotNull(result);
 
          assertEquals(customerDTO.getUserId(), result.getUserId());

          assertEquals(customerDTO.getCustomerName(), result.getCustomerName());

          assertEquals(customerDTO.getUserName(), result.getUserName());

          assertEquals(customerDTO.getAddress(), result.getAddress());

          assertEquals(customerDTO.getMobileNumber(), result.getMobileNumber());

          assertEquals(customerDTO.getPassword(), result.getPassword());

          assertEquals(customerDTO.getEmail(), result.getEmail());
 
    }


    @Test

    void testUpdateCustomerNotFound() {

        // Arrange

        CustomerDTO customerDTO = new CustomerDTO();

        Customer customerEntity = new Customer();

        when(modelMapper.map(customerDTO, Customer.class)).thenReturn(customerEntity);

        when(customerRepository.existsById(anyInt())).thenReturn(false);

        // Act and Assert

        assertThrows(CustomerNotFoundException.class, () -> customerService.updateCustomer(customerDTO));

        verify(modelMapper).map(customerDTO, Customer.class);

   //     verify(customerRepository).existsById(anyInt());

        verify(customerRepository, never()).save(customerEntity);

    }

  

//    void testViewCustomers() 
//
//    {
//
//        // Arrange
//
//        List<Customer> customerEntityList = new ArrayList<>();
//
//        List<CustomerDTO> customerDTOList = new ArrayList<>();
//
//        when(customerRepository.findAll()).thenReturn(customerEntityList);
//
//        lenient().when(modelMapper.map(any(), eq(CustomerDTO.class))).thenReturn(new CustomerDTO());
//
//        // Act
//
//        List<CustomerDTO> result = customerService.viewCustomers();
//
//        // Assert
//
//        assertEquals(customerDTOList, result);
//
//        verify(customerRepository).findAll();
//
//        verify(modelMapper, times(customerEntityList.size())).map(any(), eq(CustomerDTO.class));
//
//    }

    @Test

    void testViewCustomerById() 

    {

        // Arrange

        int customerId = 2001;

        Customer customerEntity = new Customer();

        when(customerRepository.existsById(customerId)).thenReturn(true);

        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(customerEntity));

        when(modelMapper.map(customerEntity, CustomerDTO.class)).thenReturn(new CustomerDTO());

        // Act

        CustomerDTO result = customerService.viewCustomerById(customerId);

        // Assert

        verify(customerRepository).existsById(customerId);

        verify(customerRepository).findById(customerId);

        verify(modelMapper).map(customerEntity, CustomerDTO.class);

    }

    @Test

    void testViewCustomerByIdNotFound() 

    {

        // Arrange

        int customerId = 2001;

        when(customerRepository.existsById(customerId)).thenReturn(false);

        // Act and Assert

        assertThrows(CustomerNotFoundException.class, () -> customerService.viewCustomerById(customerId));

        verify(customerRepository).existsById(customerId);

        verify(customerRepository, never()).findById(customerId);

        verify(modelMapper, never()).map(any(), eq(CustomerDTO.class));

    }

}

