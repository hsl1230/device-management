package com.telus.dl.devicemanagement.rest.controller;

import com.telus.dl.devicemanagement.document.device.Device;
import com.telus.dl.devicemanagement.dto.UpdateDeviceRequest;
import com.telus.dl.devicemanagement.service.DeviceService;
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
@RequestMapping("/api/device-management/devices")
@Validated
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService verticalService) {
        this.deviceService = verticalService;
    }

    @Operation(
            tags = { "Device" },
            summary = "get user devices"
    )
    @GetMapping
    public List<Device> findUserDevices(
            @Parameter(name = "ownerUserProfileId", in = ParameterIn.QUERY, description = "NyTelusUser Id", required = true)
            @RequestParam(value = "ownerUserProfileId") String ownerUserProfileId) {
        return deviceService.findUserDevices(ownerUserProfileId);
    }

    @Operation(
            tags = { "Device" },
            summary = "get user devices"
    )
    @GetMapping("/{dsn}")
    public Device findDeviceByDsn(@PathVariable("dsn") String dsn) {
        return deviceService.findDeviceByDsn(dsn);
    }

    @Operation(
            tags = { "Device" },
            summary = "create a user device"
    )
    @PostMapping
    public Device createDevice(@Valid @RequestBody Device device) {
        return deviceService.createDevice(device);
    }

    @Operation(
            tags = { "Device" },
            summary = "update a device"
    )
    @PutMapping("/{dsn}")
    public void updateDevice(
            @PathVariable("dsn") String dsn,
            @Valid @RequestBody UpdateDeviceRequest updateDeviceRequest) {
        deviceService.updateDevice(dsn, updateDeviceRequest);
    }

    @Operation(
            tags = { "Device" },
            summary = "delete a device"
    )
    @DeleteMapping("/{dsn}")
    public void deleteVertical(
            @PathVariable("dsn") String dsn) {
        deviceService.deleteDevice(dsn);
    }

}
