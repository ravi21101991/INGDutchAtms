package com.mobiquityinc.backbase.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class INGDutchAtmAddress {

    @JsonProperty("city")
    private String city;

    @JsonProperty("street")
    private String street;

    @JsonProperty("postalcode")
    private String postalCode;

    @JsonProperty("housenumber")
    private String houseNumber;

    @JsonProperty("geoLocation")
    private INGDutchAtmGeoLocation geoLocation;
}

