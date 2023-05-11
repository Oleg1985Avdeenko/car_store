package com.example.car_store.mapper;

import com.example.car_store.entity.cars.Color;
import com.example.car_store.service.dto.ColorDto;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {

    public ColorDto toColorDto(Color color) {
        ColorDto colorDto = ColorDto.builder()
                .colorName(color.getColorName()).build();
        return colorDto;
    }

    public Color toColorEntity(ColorDto colorDto) {
        Color color = Color.builder()
                .colorName(colorDto.getColorName()).build();
        return color;
    }
}
