package com.telus.dl.devicemanagement.dto.device;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public class DeviceDto {
    @Id
    @JsonProperty
    private String dsn;

    @NotNull
    @JsonProperty
    private String name;

    @NotNull
    @JsonProperty
    private String ownerUserProfileId;

    @NotNull(message = "device profile id is required")
    @JsonProperty
    private String deviceProfileId;

    @JsonProperty
    private PositionDto position;

    @JsonProperty
    private String ipAddress;

    @JsonProperty
    private Map<String, String> labels;
}
