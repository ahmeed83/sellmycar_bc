package com.focustechnology.sellmycar.user.repository;

import com.focustechnology.sellmycar.user.repository.domain.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DealerRepository extends JpaRepository<Dealer, UUID> {
}
