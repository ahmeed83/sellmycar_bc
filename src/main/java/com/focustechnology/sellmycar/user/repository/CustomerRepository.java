package com.focustechnology.sellmycar.user.repository;

import com.focustechnology.sellmycar.user.repository.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
