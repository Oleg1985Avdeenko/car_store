package com.example.car_store.mapper;

import com.example.car_store.entity.cars.Color;
import com.example.car_store.service.dto.ColorDto;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper implements Mapper<Color, ColorDto> {

    @Override
    public ColorDto toDto(Color color) {
        if (color == null) {
            return null;
        }
        ColorDto colorDto = ColorDto.builder()
                .colorName(color.getColorName()).build();
        return colorDto;
    }

    @Override
    public Color toEntity(ColorDto colorDto) {
        if (colorDto == null) {
            return null;
        }
        Color color = Color.builder()
                .colorName(colorDto.getColorName()).build();
        return color;
    }
}
