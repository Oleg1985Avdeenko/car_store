package com.example.car_store.dao;

import com.example.car_store.entity.cars.Car;
import com.example.car_store.entity.cars.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Integer> {
}
