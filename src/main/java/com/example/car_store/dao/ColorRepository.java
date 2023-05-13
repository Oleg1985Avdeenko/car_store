package com.example.car_store.dao;

import com.example.car_store.entity.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Car, Integer> {
}
