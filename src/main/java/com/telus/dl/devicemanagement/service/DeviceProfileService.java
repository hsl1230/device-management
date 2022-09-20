package com.telus.dl.devicemanagement.service;

import com.telus.core.errorhandling.exception.EntityNotFoundException;
import com.telus.dl.devicemanagement.document.deviceprofile.DeviceProfile;
import com.telus.dl.devicemanagement.dto.UpdateDeviceProfileRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileService {
    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;

    @Autowired
    public DeviceProfileService(MongoTemplate mongoTemplate, ModelMapper modelMapper) {
        this.mongoTemplate = mongoTemplate;
        this.modelMapper = modelMapper;
    }

    public DeviceProfile createDeviceProfile(DeviceProfile deviceProfile) {
        return mongoTemplate.insert(deviceProfile);
    }

    public void updateDeviceProfile(String deviceProfileId, UpdateDeviceProfileRequest updateDeviceProfileRequest) {
        Update update = new Update();
        if (StringUtils.isNotBlank(updateDeviceProfileRequest.name())) {
            update.set("name", updateDeviceProfileRequest.name());
        }
        if (StringUtils.isNotBlank(updateDeviceProfileRequest.manufacturer())) {
            update.set("manufacturer", updateDeviceProfileRequest.manufacturer());
        }
        if (StringUtils.isNotBlank(updateDeviceProfileRequest.model())) {
            update.set("model", updateDeviceProfileRequest.model());
        }
        if (StringUtils.isNotBlank(updateDeviceProfileRequest.description())) {
            update.set("description", updateDeviceProfileRequest.description());
        }
        if (ObjectUtils.isNotEmpty(updateDeviceProfileRequest.deviceProperties())) {
            update.set("deviceProperties", updateDeviceProfileRequest.deviceProperties());
        }
        if (ObjectUtils.isNotEmpty(updateDeviceProfileRequest.labels())) {
            update.set("labels", updateDeviceProfileRequest.labels());
        }

        if (mongoTemplate.findAndModify(new Query().addCriteria(Criteria
                .where("id")
                .is(deviceProfileId)), update, DeviceProfile.class) == null) {
            throw new EntityNotFoundException("No device profile found for id=" + deviceProfileId);
        }
    }
    
    public void deleteDeviceProfile(String deviceProfileId) {
        if (mongoTemplate.findAndRemove(new Query().addCriteria(Criteria
                .where("id")
                .is(deviceProfileId)), DeviceProfile.class) == null) {
            throw new EntityNotFoundException("No device profile found for dsn=" + deviceProfileId);
        }
    }

    public DeviceProfile findDeviceProfileById(String deviceProfileId) {
        DeviceProfile deviceProfile = mongoTemplate.findOne(new Query().addCriteria(Criteria
                .where("id")
                .is(deviceProfileId)), DeviceProfile.class);

        if (deviceProfile == null) {
            throw new EntityNotFoundException("No device profile found for dsn=" + deviceProfileId);
        }

        return deviceProfile;
    }

    public List<DeviceProfile> findDeviceProfilesByName(String regName) {
        return mongoTemplate.find(new Query().addCriteria(Criteria
                .where("name")
                .regex(regName, "i")), DeviceProfile.class);
    }
}
