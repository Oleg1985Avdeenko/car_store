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
public class UserMapper implements Mapper<User, UserDto> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
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

    @Override
    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        return UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .surname(user.getSurname())
                .cellPhone(user.getCellPhone())
                .email(user.getEmail())
                .build();
    }
}
