package com.mobiquityinc.backbase.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class INGDutchAtm {

    @JsonProperty("address")
    private INGDutchAtmAddress address;

    @JsonProperty("distance")
    private Integer distance;

    @JsonProperty("type")
    private String type;
}
