package com.example.car_store.mapper;

import com.example.car_store.entity.cars.ModelOption;
import com.example.car_store.service.dto.OptionDto;
import org.springframework.stereotype.Component;

@Component
public class ModelOptionMapper implements Mapper<ModelOption, OptionDto> {

    @Override
    public OptionDto toDto(ModelOption modelOption) {
        if (modelOption == null) {
            return null;
        }
        OptionDto optionDto = OptionDto.builder()
                .cruiseControl(modelOption.getCruiseControl())
                .fogLight(modelOption.getFogLight())
                .optionName(modelOption.getOptionName())
                .heatedSeat(modelOption.getHeatedSeat())
                .salon(modelOption.getSalon())
                .steeringWheelControl(modelOption.getSteeringWheelControl())
                .build();
        return optionDto;
    }

    @Override
    public ModelOption toEntity(OptionDto optionDto) {
        if (optionDto == null) {
            return null;
        }
        ModelOption modelOption = ModelOption.builder()
                .optionName(optionDto.getOptionName())
                .cruiseControl(optionDto.getCruiseControl())
                .fogLight(optionDto.getFogLight())
                .heatedSeat(optionDto.getHeatedSeat())
                .salon(optionDto.getSalon())
                .steeringWheelControl(optionDto.getSteeringWheelControl())
                .build();
        return modelOption;
    }
}
