package com.telus.dl.devicemanagement.dto.deviceprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public class DeviceProfileDto {
    @Id
    @JsonProperty
    private String id;

    @NotNull(message = "name is required")
    @JsonProperty
    private String name;

    @JsonProperty
    private List<DevicePropertyDto> deviceProperties;

    @JsonProperty
    private String manufacturer;

    @JsonProperty
    private String model;

    @JsonProperty
    private String description;

    @JsonProperty
    private Map<String, String> labels;
}
