package com.focustechnology.sellmycar.controller.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CarAuctionRequest {
    @JsonProperty("seller-name")
    @NotNull
    private String sellerName;
    @JsonProperty("seller-address")
    @NotNull
    private String sellerAddress;
    @JsonProperty("car-make")
    @NotNull
    private String carMake;
    @JsonProperty("car-model")
    @NotNull
    private String carModel;
    @JsonProperty("car-year")
    @NotNull
    private int carYear;
    @JsonProperty("car-price")
    @NotNull
    private double carPrice;
    @JsonProperty("general-description")
    private String generalDescription;
    @JsonProperty("car-mileage")
    @NotNull
    private int carMileage;
    @JsonProperty("car-condition-body")
    @NotNull
    private String carConditionBody;
    @JsonProperty("car-condition-interior")
    private String carConditionInterior;
}
