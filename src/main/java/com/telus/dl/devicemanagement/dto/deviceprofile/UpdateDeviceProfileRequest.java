package com.telus.dl.devicemanagement.dto.deviceprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public class UpdateDeviceProfileRequest {
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "deviceProperties")
    private List<DevicePropertyDto> deviceProperties;

    @JsonProperty(value = "manufacturer")
    private String manufacturer;

    @JsonProperty(value = "model")
    private String model;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "labels")
    private Map<String, String> labels;
}
