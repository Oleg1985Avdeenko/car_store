package com.example.car_store.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransmissionDto {

    private String type;

   // private Set<CarDto> selectedTransmissions = new HashSet<>();
}
