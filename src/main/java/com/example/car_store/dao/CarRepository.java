package com.example.car_store.dao;

import com.example.car_store.entity.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
//    Car findAllById(Integer carId);
}
