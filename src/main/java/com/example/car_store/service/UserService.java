package com.example.car_store.service;

import com.example.car_store.entity.users.User;
import com.example.car_store.service.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDto userDto);

    List<UserDto> getAll();

    User findByLogin(String login);

    void updateProfile(UserDto userDto);
}
