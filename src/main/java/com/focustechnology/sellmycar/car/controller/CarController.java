package com.focustechnology.sellmycar.car.controller;

import com.focustechnology.sellmycar.car.controller.json.CarRequest;
import com.focustechnology.sellmycar.car.mapper.CarMapper;
import com.focustechnology.sellmycar.car.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping("/create")
    public void createCarAuction(@RequestBody CarRequest carRequest) {
        carService.submitCar(carMapper.requestToDto(carRequest));
    }
}
