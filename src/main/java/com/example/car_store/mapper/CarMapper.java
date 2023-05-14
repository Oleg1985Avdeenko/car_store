package com.example.car_store.mapper;

import com.example.car_store.entity.cars.*;
import com.example.car_store.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class CarMapper implements Mapper<Car, CarDto> {
    private final TransmissionMapper transmissionMapper;
    private final EngineMapper engineMapper;
    private final ColorMapper colorMapper;
    private final ModelOptionMapper optionMapper;

    @Override
    public Car toEntity(CarDto carDto) {
        if (carDto == null) {
            return null;
        }
        Transmission transmission = transmissionMapper.toEntity(carDto.getCarTransmission());
        Engine engine = engineMapper.toEntity(carDto.getCarEngine());
        Color color = colorMapper.toEntity(carDto.getCarColor());
        ModelOption option = optionMapper.toEntity(carDto.getCarOption());
        Car.CarBuilder car = Car.builder();

        car.model(carDto.getModel());
        car.price(carDto.getPrice());
        car.availability(carDto.getAvailability());
        car.carTransmission(transmission);
        car.carEngine(engine);
        car.carColor(color);
        car.carOption(option);

        return car.build();
    }

    @Override
    public CarDto toDto(Car car) {
        if (car == null) {
            return null;
        }
        TransmissionDto transmissionDto = transmissionMapper.toDto(car.getCarTransmission());
        EngineDto engineDto = engineMapper.toDto(car.getCarEngine());
        ColorDto colorDto = colorMapper.toDto(car.getCarColor());
        OptionDto optionDto = optionMapper.toDto(car.getCarOption());
        CarDto.CarDtoBuilder carDto = CarDto.builder();
        carDto.price(car.getPrice());
        carDto.availability(car.getAvailability());
        carDto.model(car.getModel());
        carDto.carTransmission(transmissionDto);
        carDto.carEngine(engineDto);
        carDto.carColor(colorDto);
        carDto.carOption(optionDto);
        return carDto.build();
    }

    public List<Car> toCarEntityList(List<CarDto> carDtoList) {
        if (carDtoList == null) {
            return null;
        }

        List<Car> list = new ArrayList<Car>(carDtoList.size());
        for (CarDto carDto : carDtoList) {
            list.add(toEntity(carDto));
        }

        return list;
    }

    public List<CarDto> fromCarEntityList(List<Car> carList) {
        if (carList == null) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>(carList.size());
        for (Car car : carList) {
            list.add(toDto(car));
        }

        return list;
    }
}
