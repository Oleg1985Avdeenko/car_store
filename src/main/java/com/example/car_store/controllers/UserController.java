package com.example.car_store.controllers;

import com.example.car_store.entity.users.User;
import com.example.car_store.service.UserService;
import com.example.car_store.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Objects;


@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.getAll());
        return "userList";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserDto());
        return "user";
    }

    @PostMapping("/new")
    public String saveUser(UserDto userDto, Model model){
        if (userService.save(userDto)) {
            return "redirect:/users";
        } else {
            model.addAttribute("user", userDto);
        }
        return "user";
    }

    @GetMapping("/profile")
    public String profileUser(Model model, Principal principal){
        if (principal == null){
            throw new RuntimeException("You are not authorize");
        }
        User user = userService.findByLogin(principal.getName());
        UserDto userDto = UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .surname(user.getSurname())
                .cellPhone(user.getCellPhone())
                .email(user.getEmail())
                .build();
        model.addAttribute("user", userDto);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfileUser(UserDto userDto, Model model, Principal principal){
        if (principal == null || !Objects.equals(principal.getName(), userDto.getLogin())){
            throw new RuntimeException("You are not authorize");
        }
        if ((userDto.getPassword() != null)
                && !userDto.getPassword().isEmpty()
                && !Objects.equals(userDto.getPassword(), userDto.getMatchingPassword())) {
            model.addAttribute("user", userDto);
            return "profile";
        }
        userService.updateProfile(userDto);
        return "redirect:/users/profile";
    }
}
