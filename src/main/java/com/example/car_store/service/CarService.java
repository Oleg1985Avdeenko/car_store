package com.example.car_store.service;


import com.example.car_store.entity.cars.Car;
import com.example.car_store.service.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getAll();

    void addToOrder(Integer carId, String login);

    boolean save(CarDto carDto);

    CarDto findById(Integer id);

    void updateCar(CarDto carDto);

    void deleteCar(Integer id);
}
