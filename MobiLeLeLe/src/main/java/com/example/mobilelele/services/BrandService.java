package com.example.mobilelele.services;

import com.example.mobilelele.models.dto.brand.BrandDTO;
import com.example.mobilelele.models.dto.model.ModelDTO;
import com.example.mobilelele.models.entity.Brand;
import com.example.mobilelele.models.entity.Model;
import com.example.mobilelele.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
        return brandRepository.findAll().stream().map(this::mapBrand).collect(Collectors.toList());
    }

    private BrandDTO mapBrand(Brand brand) {
        List<ModelDTO> modelDTOS = brand.getModels().stream().map(this::mapModel).collect(Collectors.toList());

        return new BrandDTO()
                .setName(brand.getName())
                .setModels(modelDTOS);
    }

    private ModelDTO mapModel(Model model) {
        return new ModelDTO().setId(model.getId()).setName(model.getName());
    }
}
