package com.example.mobilelele.services;

import com.example.mobilelele.models.dto.offer.AddOfferDTO;
import com.example.mobilelele.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {

    }
}
