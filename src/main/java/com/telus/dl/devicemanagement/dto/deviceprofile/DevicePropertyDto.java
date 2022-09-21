package com.telus.dl.devicemanagement.dto.deviceprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public class DevicePropertyDto {
    @NotNull(message = "name is required")
    @JsonProperty
    private String name;

    @JsonProperty
    private PropertySchemaDto propertySchema;

    @JsonProperty
    private String description;

    @JsonProperty
    private Map<String, String> attributes;
}
