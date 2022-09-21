package com.telus.dl.devicemanagement.dto.device;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telus.dl.devicemanagement.document.device.Position;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public class UpdateDeviceRequest {
    @JsonProperty(value = "ownerUserProfileId")
    private String ownerUserProfileId;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "deviceProfileId")
    private String deviceProfileId;

    @JsonProperty(value = "ipAddress")
    private String ipAddress;

    @JsonProperty(value = "position")
    private PositionDto position;

    @JsonProperty(value = "labels")
    private Map<String, String> labels;
}
