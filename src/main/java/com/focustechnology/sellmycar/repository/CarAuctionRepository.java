package com.focustechnology.sellmycar.repository;

import com.focustechnology.sellmycar.repository.domain.CarAuction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarAuctionRepository extends CrudRepository<CarAuction, Long> {
}
