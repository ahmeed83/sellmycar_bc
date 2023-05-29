package com.focustechnology.sellmycar.car.controller;

import com.focustechnology.sellmycar.car.controller.json.CarRequest;
import com.focustechnology.sellmycar.car.mapper.CarMapper;
import com.focustechnology.sellmycar.car.repository.domain.Car;
import com.focustechnology.sellmycar.car.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-auction")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping
    public Iterable<Car> getCarAuction() {
        return carService.getCarRepository();
    }

    @PostMapping("/create")
    public void createCarAuction(@RequestBody CarRequest carAuctionRequest) {
        carService.createCarAuction(carMapper.requestToDto(carAuctionRequest));
    }
}
