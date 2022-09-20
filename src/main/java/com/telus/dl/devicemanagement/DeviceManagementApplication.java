package com.telus.dl.devicemanagement;

import com.telus.core.modelmapping.EnableModelMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.telus.core.errorhandling.EnableErrorHandling;

@EnableWebMvc
@EnableErrorHandling
@EnableModelMapping
@SpringBootApplication
public class DeviceManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeviceManagementApplication.class, args);
    }

}
