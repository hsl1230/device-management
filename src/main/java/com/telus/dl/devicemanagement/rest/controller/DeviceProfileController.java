package com.telus.dl.devicemanagement.rest.controller;

import com.telus.dl.devicemanagement.dto.deviceprofile.DeviceProfileDto;
import com.telus.dl.devicemanagement.dto.deviceprofile.UpdateDeviceProfileRequest;
import com.telus.dl.devicemanagement.service.DeviceProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/device-management/device-profiles")
@Validated
public class DeviceProfileController {
    private final DeviceProfileService deviceProfileService;

    public DeviceProfileController(DeviceProfileService deviceProfileService) {
        this.deviceProfileService = deviceProfileService;
    }

    @Operation(
            tags = { "Device Profile" },
            summary = "find device profiles of by name regular expression"
    )
    @GetMapping
    public List<DeviceProfileDto> findDeviceProfiles(
            @Parameter(name = "regName", in = ParameterIn.QUERY, description = "regular expression to match the name", required = true)
            @RequestParam(value = "regName") String regName) {
        return deviceProfileService.findDeviceProfilesByName(regName);
    }

    @Operation(
            tags = { "Device Profile" },
            summary = "find a device profile by id"
    )
    @GetMapping("/{id}")
    public DeviceProfileDto findDeviceById(@PathVariable("id") String id) {
        return deviceProfileService.findDeviceProfileById(id);
    }

    @Operation(
            tags = { "Device Profile" },
            summary = "create a device profile"
    )
    @PostMapping
    public DeviceProfileDto createDeviceProfile(@Valid @RequestBody DeviceProfileDto deviceProfile) {
        return deviceProfileService.createDeviceProfile(deviceProfile);
    }

    @Operation(
            tags = { "Device Profile" },
            summary = "update a device profile"
    )
    @PutMapping("/{id}")
    public void updateDevice(
            @PathVariable("id") String id,
            @Valid @RequestBody UpdateDeviceProfileRequest updateDeviceProfileRequest) {
        deviceProfileService.updateDeviceProfile(id, updateDeviceProfileRequest);
    }

    @Operation(
            tags = { "Device Profile" },
            summary = "delete a device profile"
    )
    @DeleteMapping("/{id}")
    public void deleteDeviceProfile(
            @PathVariable("id") String id) {
        deviceProfileService.deleteDeviceProfile(id);
    }

}
