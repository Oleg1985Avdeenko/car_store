package com.example.car_store.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EngineDto {

    private Double volume;

    private String type;

   // private Set<CarDto> selectedEngines = new HashSet<>();
}
