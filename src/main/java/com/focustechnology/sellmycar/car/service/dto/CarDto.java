package com.focustechnology.sellmycar.car.service.dto;

import lombok.Data;

@Data
public class CarDto {
    private String sellerName;
    private String sellerAddress;
    private String carMake;
    private String carModel;
    private String carYear;
    private String carPrice;
    private String generalDescription;
    private String carMileage;
    private String carConditionBody;
    private String carConditionInterior;
}
