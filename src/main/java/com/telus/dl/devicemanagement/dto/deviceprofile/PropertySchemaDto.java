package com.telus.dl.devicemanagement.dto.deviceprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telus.dl.devicemanagement.document.deviceprofile.AccessMode;
import com.telus.dl.devicemanagement.document.deviceprofile.ValueType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(fluent = true)
public class PropertySchemaDto {
    @NotNull(message = "name is required")
    @JsonProperty
    private ValueType valueType;

    @JsonProperty
    private AccessMode accessMode;

    @JsonProperty
    private String units;

    @JsonProperty
    private String minimum;

    @JsonProperty
    private String maximum;

    @JsonProperty
    private String defaultValue;

    //Mask to be applied prior to get/set of property. Only valid where Type is one of the integer types.
    @JsonProperty
    private String mask;

    //Shift to be applied after masking, prior to get/set of property. Only valid where Type is one of the integer types
    @JsonProperty
    private String shift;

    //Multiplicative factor to be applied after shifting, prior to get/set of property. Only valid where Type is one of the integer or float types
    @JsonProperty
    private String scale;

    //Additive factor to be applied after multiplying, prior to get/set of property. Only valid where Type is one of the integer or float types
    @JsonProperty
    private String offset;

    //Base for property to be applied to, leave 0 for no power operation (i.e. base ^ property: 2 ^ 10). Only valid where Type is one of the integer or float types.
    @JsonProperty
    private String base;

    //Required value of the property, set for checking error state. Failing an assertion condition will mark the device with an error state
    @JsonProperty
    private String assertion;

    //A string value used to indicate the type of binary data if Type=binary
    @JsonProperty
    private String mediaType;
}
