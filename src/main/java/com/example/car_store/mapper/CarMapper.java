package com.example.car_store.mapper;

import com.example.car_store.entity.cars.Car;
import com.example.car_store.service.dto.CarDto;
import com.example.car_store.service.dto.ColorDto;
import com.example.car_store.service.dto.EngineDto;
import com.example.car_store.service.dto.TransmissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class CarMapper {
    private final TransmissionMapper transmissionMapper;
    private final EngineMapper engineMapper;
    private final ColorMapper colorMapper;

    public Car toCarEntity(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.id( carDto.getId() );
        car.model( carDto.getModel() );
        car.price( carDto.getPrice() );
        car.availability( carDto.getAvailability() );


        return car.build();
    }

    public CarDto toCarDto(Car car) {

        if ( car == null ) {
            return null;
        }
        TransmissionDto transmissionDto = transmissionMapper.transmissionToDto(car.getCarTransmission());
        EngineDto engineDto = engineMapper.toEngineDto(car.getCarEngine());
        ColorDto colorDto = colorMapper.toColorDto(car.getCarColor());
        CarDto.CarDtoBuilder carDto = CarDto.builder();

        carDto.id( car.getId() );
        carDto.price( car.getPrice() );
        carDto.availability( car.getAvailability() );
        carDto.model( car.getModel() );
       carDto.carTransmission(transmissionDto);
       carDto.carEngine(engineDto);
       carDto.carColor(colorDto);
        return carDto.build();

    }

    public List<Car> toCarEntityList(List<CarDto> carDtoList) {
        if ( carDtoList == null ) {
            return null;
        }

        List<Car> list = new ArrayList<Car>( carDtoList.size() );
        for ( CarDto carDto : carDtoList ) {
            list.add( toCarEntity( carDto ) );
        }

        return list;
    }

    public List<CarDto> fromCarEntityList(List<Car> carList) {
        if ( carList == null ) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>( carList.size() );
        for ( Car car : carList ) {
            list.add( toCarDto( car ) );
        }

        return list;
    }
}
