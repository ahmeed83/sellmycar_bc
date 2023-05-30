package com.focustechnology.sellmycar.car.mapper;

import com.focustechnology.sellmycar.car.controller.json.CarRequest;
import com.focustechnology.sellmycar.car.repository.domain.Car;
import com.focustechnology.sellmycar.car.service.dto.CarDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto requestToDto(CarRequest request);
    Car dtoToEntity(CarDto dto);
}
