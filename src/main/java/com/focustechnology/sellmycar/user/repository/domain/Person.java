package com.focustechnology.sellmycar.user.repository.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@SuperBuilder
@NoArgsConstructor
@Getter
public class Person {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
    private String telNr;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //eager is needed for the JWT filter
    private List<Login> logins = new ArrayList<>();
}
