package com.telus.dl.devicemanagement.repository;

import com.telus.dl.devicemanagement.document.deviceprofile.DeviceProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceProfileRepository extends MongoRepository<DeviceProfile, String> {
}
