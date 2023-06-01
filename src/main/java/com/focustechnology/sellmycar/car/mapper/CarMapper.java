package com.focustechnology.sellmycar.car.mapper;

import com.focustechnology.sellmycar.car.controller.json.CarRequest;
import com.focustechnology.sellmycar.car.repository.domain.Car;
import com.focustechnology.sellmycar.car.service.dto.CarDto;
import com.focustechnology.sellmycar.user.repository.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto requestToDto(CarRequest request);

    @Mapping(target = "verified", ignore = true)
    default Car dtoToEntity(CarDto dto) {
        return Car.toBuilder()
                .make(dto.getCarMake())
                .model(dto.getCarModel())
                .year(dto.getCarYear())
                .mileage(dto.getCarMileage())
                .description(dto.getGeneralDescription())
                .conditionBody(dto.getCarConditionBody())
                .conditionInterior(dto.getCarConditionInterior())
                .customer(toCustomer(dto))
                .build();
    }

    private Customer toCustomer(CarDto dto) {
        return Customer.builder()
                .firstName(dto.getSellerName())
                .address(dto.getSellerAddress())
                .cars(new ArrayList<>())
                .build();
    }
}
