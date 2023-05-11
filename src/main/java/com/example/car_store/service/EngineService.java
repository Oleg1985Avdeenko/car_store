package com.example.car_store.service;

import com.example.car_store.service.dto.EngineDto;

public interface EngineService {
    EngineDto findById(Integer id);
}
