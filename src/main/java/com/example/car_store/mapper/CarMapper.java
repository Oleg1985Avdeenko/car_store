package com.example.car_store.mapper;

import com.example.car_store.entity.cars.Car;
import com.example.car_store.service.dto.CarDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);

    Car toCarEntity(CarDto carDto);

   // @InheritInverseConfiguration
    CarDto fromCarEntity(Car car);

    List<Car> toCarEntityList(List<CarDto> carDtoList);

    List<CarDto> fromCarEntityList(List<Car> carList);
}
