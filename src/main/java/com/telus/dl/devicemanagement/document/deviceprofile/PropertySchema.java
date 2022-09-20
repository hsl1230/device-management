package com.telus.dl.devicemanagement.document.deviceprofile;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(fluent = true)
public class PropertySchema {
    @NotNull(message = "name is required")
    private ValueType valueType;

    private AccessMode accessMode;

    private String units;

    private String minimum;
    private String maximum;
    private String defaultValue;

    //Mask to be applied prior to get/set of property. Only valid where Type is one of the integer types.
    private String mask;

    //Shift to be applied after masking, prior to get/set of property. Only valid where Type is one of the integer types
    private String shift;

    //Multiplicative factor to be applied after shifting, prior to get/set of property. Only valid where Type is one of the integer or float types
    private String scale;

    //Additive factor to be applied after multiplying, prior to get/set of property. Only valid where Type is one of the integer or float types
    private String offset;

    //Base for property to be applied to, leave 0 for no power operation (i.e. base ^ property: 2 ^ 10). Only valid where Type is one of the integer or float types.
    private String base;

    //Required value of the property, set for checking error state. Failing an assertion condition will mark the device with an error state
    private String assertion;

    //A string value used to indicate the type of binary data if Type=binary
    private String mediaType;
}
