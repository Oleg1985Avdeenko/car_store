package com.example.car_store.service.dto;

import com.example.car_store.entity.cars.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {

    private String model;
    private Integer carId;
    private BigDecimal price;
    private BigDecimal amount;

    private Engine carEngine;

    private Color carColor;

    private Transmission carTransmission;

    private ModelOption modelOption;
    private double sum;

    public OrderDetailDto(Car car) {
        this.model = car.getModel();
        this.carId = car.getId();
        this.price = car.getPrice();
        this.carEngine = car.getCarEngine();
        this.carColor = car.getCarColor();
        this.carTransmission = car.getCarTransmission();
        this.modelOption = car.getCarOption();
        this.amount = new BigDecimal(1.0);
        this.sum = Double.valueOf(car.getPrice().toString());
    }
}
