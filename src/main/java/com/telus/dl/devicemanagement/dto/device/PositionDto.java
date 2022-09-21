package com.telus.dl.devicemanagement.dto.device;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class PositionDto {
    @JsonProperty
    private String latitude;

    @JsonProperty
    private String longitude;
}
