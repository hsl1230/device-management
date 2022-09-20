package com.telus.dl.devicemanagement.document.deviceprofile;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public class DeviceProperty {
    @NotNull(message = "name is required")
    private String name;

    private PropertySchema propertySchema;

    private String description;

    private Map<String, String> attributes;
}
