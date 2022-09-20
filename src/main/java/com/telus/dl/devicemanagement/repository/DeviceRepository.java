package com.telus.dl.devicemanagement.repository;

import com.telus.dl.devicemanagement.document.device.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device, String> {
}
