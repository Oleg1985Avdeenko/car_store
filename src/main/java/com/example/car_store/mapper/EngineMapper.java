package com.example.car_store.mapper;

import com.example.car_store.entity.cars.Engine;
import com.example.car_store.service.dto.EngineDto;
import org.springframework.stereotype.Component;

@Component
public class EngineMapper implements Mapper<Engine, EngineDto> {

    @Override
    public Engine toEntity(EngineDto engineDto) {
        if (engineDto == null) {
            return null;
        }
        Engine.EngineBuilder engine = Engine.builder();
        engine.type(engineDto.getType());
        engine.volume(engineDto.getVolume());
        return engine.build();
    }

    @Override
    public EngineDto toDto(Engine engine) {
        if (engine == null) {
            return null;
        }
        EngineDto.EngineDtoBuilder engineDto = EngineDto.builder();
        engineDto.type(engine.getType());
        engineDto.volume(engine.getVolume());
        return engineDto.build();
    }


}
