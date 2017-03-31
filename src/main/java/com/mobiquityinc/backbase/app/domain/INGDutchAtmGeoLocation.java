package com.mobiquityinc.backbase.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class INGDutchAtmGeoLocation {

    @JsonProperty("lat")
    private String lattitude;

    @JsonProperty("lng")
    private String longitude;
}
