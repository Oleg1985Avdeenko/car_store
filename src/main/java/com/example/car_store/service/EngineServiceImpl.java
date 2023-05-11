package com.example.car_store.service;

import com.example.car_store.dao.EngineRepository;
import com.example.car_store.entity.cars.Engine;
import com.example.car_store.mapper.EngineMapper;
import com.example.car_store.service.dto.EngineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService{

    private final EngineRepository engineRepository;
    private final EngineMapper mapper;

    @Override
    public EngineDto findById(Integer id) {
        Engine engine = engineRepository.getById(id);
        return mapper.toEngineDto(engine);
    }



}
