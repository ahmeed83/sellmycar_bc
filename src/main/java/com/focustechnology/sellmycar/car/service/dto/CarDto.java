package com.focustechnology.sellmycar.car.service.dto;

import lombok.Data;

@Data
public class CarDto {
    private String sellerName;
    private String sellerAddress;
    private String carMake;
    private String carModel;
    private int carYear;
    private double carPrice;
    private String generalDescription;
    private int carMileage;
    private String carConditionBody;
    private String carConditionInterior;
}
