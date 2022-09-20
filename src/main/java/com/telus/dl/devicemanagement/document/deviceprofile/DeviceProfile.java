package com.telus.dl.devicemanagement.document.deviceprofile;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Document(collection = "device-profile")
@Getter
@Setter
@Accessors(fluent = true)
public class DeviceProfile {
    @Id
    private String id;

    @NotNull(message = "name is required")
    private String name;

    private List<DeviceProperty> deviceProperties;

    private String manufacturer;
    private String model;
    private String description;

    private Map<String, String> labels;

}
