package com.focustechnology.sellmycar.service;

import com.focustechnology.sellmycar.mapper.CarAuctionMapper;
import com.focustechnology.sellmycar.repository.CarAuctionRepository;
import com.focustechnology.sellmycar.repository.domain.CarAuction;
import com.focustechnology.sellmycar.service.dto.CarAuctionDto;
import org.springframework.stereotype.Service;

@Service
public class CarAuctionService {

    private final CarAuctionRepository carAuctionRepository;
    private final CarAuctionMapper carAuctionMapper;

    public CarAuctionService(CarAuctionRepository carAuctionRepository, CarAuctionMapper carAuctionMapper) {
        this.carAuctionRepository = carAuctionRepository;
        this.carAuctionMapper = carAuctionMapper;
    }

    public Iterable<CarAuction> getCarAuctionRepository() {
        return carAuctionRepository.findAll();
    }

    public void createCarAuction(CarAuctionDto carAuctionDto) {
        carAuctionRepository.save(carAuctionMapper.dtoToEntity(carAuctionDto));
    }
}
