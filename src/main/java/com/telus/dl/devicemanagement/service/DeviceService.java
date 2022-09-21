package com.telus.dl.devicemanagement.service;

import com.telus.core.errorhandling.exception.EntityNotFoundException;
import com.telus.dl.devicemanagement.document.device.Device;
import com.telus.dl.devicemanagement.dto.device.DeviceDto;
import com.telus.dl.devicemanagement.dto.device.UpdateDeviceRequest;
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
public class DeviceService {
    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;

    @Autowired
    public DeviceService(MongoTemplate mongoTemplate, ModelMapper modelMapper) {
        this.mongoTemplate = mongoTemplate;
        this.modelMapper = modelMapper;
    }

    public DeviceDto createDevice(DeviceDto deviceDto) {
        return modelMapper.map(
                mongoTemplate.insert(modelMapper.map(deviceDto, Device.class)),
                DeviceDto.class);
    }

    public void updateDevice(String dsn, UpdateDeviceRequest updateDeviceRequest) {
        Update update = new Update();
        if (StringUtils.isNotBlank(updateDeviceRequest.name())) {
            update.set("name", updateDeviceRequest.name());
        }
        if (StringUtils.isNotBlank(updateDeviceRequest.ownerUserProfileId())) {
            update.set("ownerUserProfileId", updateDeviceRequest.ownerUserProfileId());
        }
        if (StringUtils.isNotBlank(updateDeviceRequest.deviceProfileId())) {
            update.set("deviceProfileId", updateDeviceRequest.deviceProfileId());
        }
        if (StringUtils.isNotBlank(updateDeviceRequest.ipAddress())) {
            update.set("ipAddress", updateDeviceRequest.ipAddress());
        }
        if (ObjectUtils.isNotEmpty(updateDeviceRequest.labels())) {
            update.set("labels", updateDeviceRequest.labels());
        }
        if (updateDeviceRequest.position() != null) {
            update.set("position", updateDeviceRequest.position());
        }

        if (mongoTemplate.findAndModify(new Query().addCriteria(Criteria
                .where("id")
                .is(dsn)), update, Device.class) == null) {
            throw new EntityNotFoundException("No device found for dsn=" + dsn);
        }
    }

    public void deleteDevice(String dsn) {
        if (mongoTemplate.findAndRemove(new Query().addCriteria(Criteria
                .where("dsn")
                .is(dsn)), Device.class) == null) {
            throw new EntityNotFoundException("No device found for dsn=" + dsn);
        }
    }

    public DeviceDto findDeviceByDsn(String dsn) {
        Device device = mongoTemplate.findOne(new Query().addCriteria(Criteria
                        .where("dsn")
                        .is(dsn)),Device.class);

        if (device == null) {
            throw new EntityNotFoundException("No device found for dsn=" + dsn);
        }

        return modelMapper.map(device, DeviceDto.class);
    }

    public List<DeviceDto> findUserDevices(String ownerUserProfileId) {
        return mongoTemplate.find(new Query().addCriteria(Criteria
                        .where("ownerUserProfileId")
                        .is(ownerUserProfileId)), Device.class)
                .stream()
                .map(device -> modelMapper.map(device, DeviceDto.class))
                .toList();
    }
}
