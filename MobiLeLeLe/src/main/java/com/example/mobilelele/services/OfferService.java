package com.example.mobilelele.services;

import com.example.mobilelele.models.dto.offer.AddOfferDTO;
import com.example.mobilelele.models.entity.Model;
import com.example.mobilelele.models.entity.Offer;
import com.example.mobilelele.models.entity.User;
import com.example.mobilelele.models.mapper.OfferMapper;
import com.example.mobilelele.repositories.ModelRepository;
import com.example.mobilelele.repositories.OfferRepository;
import com.example.mobilelele.repositories.UserRepository;
import com.example.mobilelele.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    private final OfferMapper offerMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelRepository modelRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper,
                        UserRepository userRepository, CurrentUser currentUser,
                        ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }


    public void addOffer(AddOfferDTO addOfferDTO) {
        Offer newOffer = offerMapper.addOfferDTOToOffer(addOfferDTO);

        Optional<User> user = userRepository.findByEmail(currentUser.getEmail());

        Optional<Model> model = modelRepository.findById(addOfferDTO.getModelId());

        newOffer.setModel(model.get()).setSeller(user.get());

        offerRepository.save(newOffer);
    }
}
