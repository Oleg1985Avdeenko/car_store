package com.example.car_store.mapper;

import com.example.car_store.entity.users.User;
import com.example.car_store.service.dto.UserDto;

public interface Mapper<TEntity, TDto> {
    TEntity toEntity(TDto dto);

    TDto toDto(TEntity entity);

}
