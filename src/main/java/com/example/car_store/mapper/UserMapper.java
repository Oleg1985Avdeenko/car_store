package com.example.car_store.mapper;

import com.example.car_store.entity.users.Role;
import com.example.car_store.entity.users.User;
import com.example.car_store.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public User mapToEntity(UserDto userDto) {
        User user = User.builder()
                .login(userDto.getLogin())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .cellPhone(userDto.getCellPhone())
                .email(userDto.getEmail())
                .role(Role.CLIENT)
                .build();

        Optional.ofNullable(userDto.getPassword())
                .map(passwordEncoder::encode)
                .ifPresent(user::setPassword);

        return user;
    }

    public UserDto mapToDto(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .surname(user.getSurname())
                .cellPhone(user.getCellPhone())
                .email(user.getEmail())
                .build();
    }
}
