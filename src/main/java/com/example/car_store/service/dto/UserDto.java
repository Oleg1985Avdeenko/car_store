package com.example.car_store.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String login;

    private String password;

    private String matchingPassword;

    private String name;

    private String surname;

    private String cellPhone;

    private String email;

    private Set<OrderDto> dtoOrders = new HashSet<>();
}
