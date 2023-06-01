package com.focustechnology.sellmycar.car.service;

import com.focustechnology.sellmycar.car.mapper.CarMapper;
import com.focustechnology.sellmycar.car.repository.CarRepository;
import com.focustechnology.sellmycar.car.repository.domain.Car;
import com.focustechnology.sellmycar.car.service.dto.CarDto;
import com.focustechnology.sellmycar.user.repository.CustomerRepository;
import com.focustechnology.sellmycar.user.repository.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

    private final CarMapper carMapper;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    public CarService(final CarRepository carRepository,
                      final CarMapper carMapper,
                      final CustomerRepository customerRepository) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void submitCar(CarDto carDto) {
        Car car = carMapper.dtoToEntity(carDto);
        Customer customer = car.getCustomer();
        customer = customerRepository.save(customer);
        car = carRepository.save(car);
        customer.getCars().add(car);
        customerRepository.save(customer);
    }
}
