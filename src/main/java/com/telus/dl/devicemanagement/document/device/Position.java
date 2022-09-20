package com.telus.dl.devicemanagement.document.device;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class Position {
    private String latitude;
    private String longitude;
}
