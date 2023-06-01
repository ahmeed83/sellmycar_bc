package com.focustechnology.sellmycar.car.repository.domain;

import com.focustechnology.sellmycar.user.repository.domain.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "car", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "toBuilder")
@Getter
public class Car {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer mileage;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String conditionBody;
    @Column(nullable = false)
    private String conditionInterior;
    @Column(nullable = false)
    private boolean verified;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;
}
