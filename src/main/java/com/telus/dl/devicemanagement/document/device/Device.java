package com.telus.dl.devicemanagement.document.device;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Document(collection = "device-profile")
@Getter
@Setter
@Accessors(fluent = true)
public class Device {
    @Id
    private String dsn;

    @NotNull
    private String name;

    @NotNull
    private String ownerUserProfileId;

    @NotNull(message = "device profile id is required")
    private String deviceProfileId;

    private Position position;

    private String ipAddress;

    private Map<String, String> labels;
}
