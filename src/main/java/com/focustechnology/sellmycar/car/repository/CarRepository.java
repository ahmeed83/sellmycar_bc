package com.focustechnology.sellmycar.car.repository;

import com.focustechnology.sellmycar.car.repository.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
