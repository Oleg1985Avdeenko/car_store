package com.example.car_store.service.dto;

import javax.persistence.Table;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

    private Integer id;
    private BigDecimal price;

    private Boolean availability;

    private String model;

//    private OrderDto dtoSelectedCar;
//
      private EngineDto carEngine;
//
    private ColorDto carColor;
//
   private TransmissionDto carTransmission;
//
//    private OptionDto carOption;
}
