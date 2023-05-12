package com.focustechnology.sellmycar.service.dto;

import lombok.Data;

@Data
public class CarAuctionDto {
    private String make;
    private String model;
    private int year;
    private double price;
    private String description;
}
