package com.example.mobilelele.models.dto.brand;

import com.example.mobilelele.models.dto.model.ModelDTO;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private String name;

    private List<ModelDTO> models;

    public BrandDTO() {
        this.models = new ArrayList<>();
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public BrandDTO setModels(List<ModelDTO> models) {
        this.models = models;
        return this;
    }

    public BrandDTO addModels(ModelDTO model) {
        this.models.add(model);
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandDTO setName(String name) {
        this.name = name;
        return this;
    }
}
