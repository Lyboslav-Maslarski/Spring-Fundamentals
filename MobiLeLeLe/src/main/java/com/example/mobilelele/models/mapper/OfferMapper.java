package com.example.mobilelele.models.mapper;

import com.example.mobilelele.models.dto.offer.AddOfferDTO;
import com.example.mobilelele.models.entity.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    Offer addOfferDTOToOffer(AddOfferDTO addOfferDTO);
}
