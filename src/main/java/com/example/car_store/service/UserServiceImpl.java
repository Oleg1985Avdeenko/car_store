package com.example.car_store.service;


import com.example.car_store.dao.UserRepository;
import com.example.car_store.entity.users.User;
import com.example.car_store.mapper.UserMapper;
import com.example.car_store.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;//__________


    @Override
    public boolean save(UserDto userDto) {
        if (!Objects.equals(userDto.getPassword(), userDto.getMatchingPassword())) {
            throw new RuntimeException("Password is not equals!");
        }
        User user = mapper.toEntity(userDto);
        userRepository.save(user);
        return true;
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
//        System.out.println("/////////////////////////////");
//        System.out.println(username + "//loginname");
        if (user == null) {
            throw new UsernameNotFoundException("User not found with name: " + username);
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                roles);
    }


    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void updateProfile(UserDto userDto) {
        User savedUser = userRepository.findByLogin(userDto.getLogin());
        if (savedUser == null) {
            throw new RuntimeException("User not found by login " + userDto.getLogin());
        }
        boolean isChanged = false;
        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            savedUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
            isChanged = true;
        }
        if (!Objects.equals(userDto.getName(), savedUser.getName())) {
            savedUser.setName(userDto.getName());
            isChanged = true;
        }
        if (!Objects.equals(userDto.getSurname(), savedUser.getSurname())) {
            savedUser.setSurname(userDto.getSurname());
            isChanged = true;
        }
        if (!Objects.equals(userDto.getCellPhone(), savedUser.getCellPhone())) {
            savedUser.setCellPhone(userDto.getCellPhone());
            isChanged = true;
        }
        if (!Objects.equals(userDto.getEmail(), savedUser.getEmail())) {
            savedUser.setEmail(userDto.getEmail());
            isChanged = true;
        }
        if (isChanged) {
            userRepository.save(savedUser);
        }
    }
}
