package com.telus.dl.devicemanagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.telus.dl.devicemanagement.rest.controller.DeviceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeviceManagementApplicationTests {
    @Autowired
    private DeviceController controller;

    @Test
    void contextLoads() {
        assertNotNull(controller);
    }
}
