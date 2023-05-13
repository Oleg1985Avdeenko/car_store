package com.example.car_store.mapper;

import com.example.car_store.entity.cars.ModelOption;
import com.example.car_store.service.dto.OptionDto;
import org.springframework.stereotype.Component;

@Component
public class ModelOptionMapper {

    public OptionDto toDto(ModelOption modelOption){
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

    public ModelOption toEntity(){
        ModelOption modelOption = ModelOption.builder()
                .optionName("rhn")
                .cruiseControl(true)
                .fogLight(true)
                .heatedSeat(true)
                .salon("moim")
                .steeringWheelControl(true)
                .build();
        return modelOption;
    }
}
