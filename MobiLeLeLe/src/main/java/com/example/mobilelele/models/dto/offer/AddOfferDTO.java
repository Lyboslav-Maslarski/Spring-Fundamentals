package com.example.mobilelele.models.dto.offer;

import com.example.mobilelele.models.enums.EngineEnum;
import com.example.mobilelele.models.enums.TransmissionEnum;
import jakarta.validation.constraints.*;

public class AddOfferDTO {
    @NotNull
    @Min(1)
    private long modelId;

    @NotNull
    @Positive
    private Integer price;

    @NotNull
    @Min(1900)
    private Integer year;

    @NotNull
    @PositiveOrZero
    private Integer mileage;

    @NotEmpty
    private String description;
    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;

    @NotEmpty
    private String imageUrl;

    public EngineEnum getEngine() {
        return engine;
    }

    public AddOfferDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public AddOfferDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public long getModelId() {
        return modelId;
    }

    public AddOfferDTO setModelId(long modelId) {
        this.modelId = modelId;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
