package com.focustechnology.sellmycar.car.service;

import com.focustechnology.sellmycar.car.mapper.CarMapper;
import com.focustechnology.sellmycar.car.repository.CarRepository;
import com.focustechnology.sellmycar.car.repository.domain.Car;
import com.focustechnology.sellmycar.car.service.dto.CarDto;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public Iterable<Car> getCarRepository() {
        return carRepository.findAll();
    }

    public void createCarAuction(CarDto carDto) {
        carRepository.save(carMapper.dtoToEntity(carDto));
    }
}
