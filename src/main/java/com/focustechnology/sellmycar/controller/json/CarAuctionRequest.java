package com.focustechnology.sellmycar.controller.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CarAuctionRequest {
    @JsonProperty("make")
    @NotNull
    private String make;
    @JsonProperty("model")
    @NotNull
    private String model;
    @JsonProperty("year")
    @NotNull
    private int year;
    @JsonProperty("price")
    @NotNull
    private double price;
    @JsonProperty("description")
    private String description;
}
