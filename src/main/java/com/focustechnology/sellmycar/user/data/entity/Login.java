package com.focustechnology.sellmycar.user.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Login {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String loginName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    Boolean active;
}
