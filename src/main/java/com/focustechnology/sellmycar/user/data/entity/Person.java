package com.focustechnology.sellmycar.user.data.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@MappedSuperclass
abstract class Person {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String address;

    @OneToMany
    private List<Login> logins = new ArrayList<>();

}
