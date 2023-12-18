package com.cabmanagementsystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import com.cabmanagementsystem.dto.AdminDTO;
import com.cabmanagementsystem.entity.Admin;
import com.cabmanagementsystem.repository.AdminRepository;
import com.cabmanagementsystem.service.AdminService;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
	@Mock
	private AdminRepository adminRepository;
	@Mock
	private ModelMapper modelMapper;
	@InjectMocks
	private AdminService adminService;

	@Test
	public void testViewAdmins() {
		// Mocking data
		List<Admin> admin1 = new ArrayList<>();
		List<Admin> admin2 = new ArrayList<>();
		// Mocking behavior
		when(adminRepository.findAll()).thenReturn(admin1);
		lenient().when(modelMapper.map(any(), eq(AdminDTO.class))).thenReturn(new AdminDTO());
		// Act
		List<AdminDTO> result = adminService.viewAdmins();
		// Assert
		assertEquals(admin2, result);
		verify(adminRepository).findAll();
		verify(modelMapper, times(admin1.size())).map(any(), eq(AdminDTO.class));
	}

//	@Test
//	public void testViewAdminById() {
//		// Mocking data
//		Admin admin = new Admin();
//		// admin.setUserId();
//		// admin.setAdminName("admin1");
//		// Mocking behavior
//		when(adminRepository.findById(admin.getUserId())).thenReturn(Optional.of(admin));
//		lenient().when(modelMapper.map(any(), eq(AdminDTO.class))).thenReturn(new AdminDTO());
//		AdminDTO result = adminService.viewAdminById(admin.getUserId());
//		assertNotNull(result);
//		assertEquals(admin.getUserId(), result.getUserId());
//		assertEquals(admin.getAdminName(), result.getAdminName());
//	}
}