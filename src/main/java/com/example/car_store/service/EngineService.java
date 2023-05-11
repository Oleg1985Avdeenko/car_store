package com.example.car_store.service;

import com.example.car_store.entity.cars.Engine;
import com.example.car_store.service.dto.EngineDto;

import java.util.Optional;

public interface EngineService {
    EngineDto findById(Integer id);
}
