package com.telus.dl.devicemanagement.service;

import com.telus.dl.devicemanagement.document.device.Device;
import com.telus.dl.devicemanagement.util.MockModelMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceTest {
	@Mock
	private MongoTemplate mongoTemplate;
	@Spy
	private ModelMapper modelMapper = new MockModelMapper();

	@InjectMocks
	private DeviceService deviceService;

	@BeforeEach
	public void setUp() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		when(mongoTemplate.insert(any(Device.class))).thenReturn(
				new Device()
		);
	}

	@Test
	public void testCreatePrimaryUserProfile() {
		Device device = new Device()
				.name("switch001")
				.deviceProfileId("dell-switch")
				.dsn("T12341234-11");

		assertNotNull(this.deviceService.createDevice(device));
	}
}
