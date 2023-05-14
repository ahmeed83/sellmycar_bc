package com.focustechnology.sellmycar.controller;

import com.focustechnology.sellmycar.controller.json.CarAuctionRequest;
import com.focustechnology.sellmycar.mapper.CarAuctionMapper;
import com.focustechnology.sellmycar.repository.domain.CarAuction;
import com.focustechnology.sellmycar.service.CarAuctionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-auction")
public class CarAuctionController {

    private final CarAuctionService carAuctionService;
    private final CarAuctionMapper carAuctionMapper;

    public CarAuctionController(CarAuctionService carAuctionService, CarAuctionMapper carAuctionMapper) {
        this.carAuctionService = carAuctionService;
        this.carAuctionMapper = carAuctionMapper;
    }

    @GetMapping
    public Iterable<CarAuction> getCarAuction() {
        return carAuctionService.getCarAuctionRepository();
    }

    @PostMapping("/create")
    public void createCarAuction(@RequestBody CarAuctionRequest carAuctionRequest) {
        carAuctionService.createCarAuction(carAuctionMapper.requestToDto(carAuctionRequest));
    }
}
