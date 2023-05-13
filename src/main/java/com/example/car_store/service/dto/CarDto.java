package com.example.car_store.service.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal price;

    private Boolean availability;

    private String model;

    //    private OrderDto dtoSelectedCar;

    private EngineDto carEngine;

    private ColorDto carColor;

    private TransmissionDto carTransmission;

//    private OptionDto carOption;
}
