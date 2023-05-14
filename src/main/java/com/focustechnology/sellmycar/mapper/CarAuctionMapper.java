package com.focustechnology.sellmycar.mapper;

import com.focustechnology.sellmycar.controller.json.CarAuctionRequest;
import com.focustechnology.sellmycar.repository.domain.CarAuction;
import com.focustechnology.sellmycar.service.dto.CarAuctionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarAuctionMapper {
    CarAuctionDto requestToDto(CarAuctionRequest request);
    CarAuction dtoToEntity(CarAuctionDto dto);
}
