package com.example.car_store.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColorDto {

    private String colorName;

    private Set<CarDto> selectedColors = new HashSet<>();
}
