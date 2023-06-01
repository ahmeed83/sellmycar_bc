package com.focustechnology.sellmycar.user.repository.domain;

import com.focustechnology.sellmycar.car.repository.domain.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Entity
@Getter
public class Customer extends Person {

    @OneToMany(mappedBy = "customer")
    private List<Car> cars;
}
