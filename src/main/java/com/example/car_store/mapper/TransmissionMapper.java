package com.example.car_store.mapper;

import com.example.car_store.entity.cars.Transmission;
import com.example.car_store.service.dto.TransmissionDto;
import org.springframework.stereotype.Component;

@Component
public class TransmissionMapper implements Mapper<Transmission, TransmissionDto> {

    @Override
    public Transmission toEntity(TransmissionDto transmissionDto) {
        if (transmissionDto == null) {
            return null;
        }
        Transmission transmission = Transmission.builder()
                .type(transmissionDto.getType())
                .build();
        return transmission;
    }

    @Override
    public TransmissionDto toDto(Transmission transmission) {
        if (transmission == null) {
            return null;
        }
        TransmissionDto transmissionDto = TransmissionDto.builder()
                .type(transmission.getType()).build();
        return transmissionDto;
    }


}
