package com.example.car_store.mapper;

import com.example.car_store.entity.cars.Transmission;
import com.example.car_store.service.dto.TransmissionDto;
import org.springframework.stereotype.Component;

@Component
public class TransmissionMapper {


    public Transmission transmissionToEntity(TransmissionDto transmissionDto) {
        Transmission transmission = Transmission.builder()
                .type(transmissionDto.getType())
                .build();
        return transmission;
    }

    TransmissionDto transmissionToDto(Transmission transmission) {
        TransmissionDto transmissionDto = TransmissionDto.builder()
                .type(transmission.getType()).build();
        return transmissionDto;
    }


}
