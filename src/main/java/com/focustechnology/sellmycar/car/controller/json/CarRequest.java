package com.focustechnology.sellmycar.car.controller.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CarRequest {
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
    private int carYear;
    @JsonProperty("car-price")
    private double carPrice;
    @JsonProperty("general-description")
    private String generalDescription;
    @JsonProperty("car-mileage")
    private int carMileage;
    @JsonProperty("car-condition-body")
    @NotNull
    private String carConditionBody;
    @JsonProperty("car-condition-interior")
    private String carConditionInterior;
}
