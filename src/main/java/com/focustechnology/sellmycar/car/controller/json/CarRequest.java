package com.focustechnology.sellmycar.car.controller.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CarRequest {
    @NotNull
    @JsonProperty("seller-name")
    private String sellerName;
    @NotNull
    @JsonProperty("seller-address")
    private String sellerAddress;
    @NotNull
    @JsonProperty("car-make")
    private String carMake;
    @NotNull
    @JsonProperty("car-model")
    private String carModel;
    @NotNull
    @JsonProperty("car-year")
    private String  carYear;
    @NotNull
    @JsonProperty("car-price")
    private String carPrice;
    @NotNull
    @JsonProperty("car-mileage")
    private String carMileage;
    @NotNull
    @JsonProperty("car-condition-body")
    private String carConditionBody;
    @NotNull
    @JsonProperty("car-condition-interior")
    private String carConditionInterior;
    @JsonProperty("general-description")
    private String generalDescription;
}
