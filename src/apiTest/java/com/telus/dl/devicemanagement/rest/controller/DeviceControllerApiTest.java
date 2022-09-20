package com.telus.dl.devicemanagement.rest.controller;

import com.telus.dl.devicemanagement.DeviceManagementApplication;
import com.telus.dl.devicemanagement.service.DeviceService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {
		DeviceManagementApplication.class,
		DeviceController.class })
public class DeviceControllerApiTest {
	private static final String CONTENT_TYPE = "application/json";
	@Value("${local.server.port}")
	private int port;

	@Autowired
	@InjectMocks
	private DeviceService dowJonesIndexService;

	@Mock
	private MongoTemplate mongoTemplate;

	@BeforeEach
	public void setup() {
		RestAssured.port = port;
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void findDowJonesIndicesSuccess() {
//		List<DowJonesIndex> mockListOfDowJonesIndex = JsonLoaderUtil.getObjectFrom(
//				"list-of-dow-jones-index.json",
//				new TypeReference<List<DowJonesIndex>>() {
//				});
//		when(dowJonesIndexRepository.findByStock(anyString())).thenReturn(mockListOfDowJonesIndex);
//
//		given()
//				.contentType(CONTENT_TYPE)
//				.queryParam("stock", "AA")
//				.when().get("/api/dow-jones-indices")
//				.then().log().all().statusCode(HttpStatus.SC_OK);
	}
}
