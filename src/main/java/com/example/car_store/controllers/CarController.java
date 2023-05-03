package com.example.car_store.controllers;

import com.example.car_store.service.CarService;
import com.example.car_store.service.dto.CarDto;
import com.example.car_store.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public String list(Model model) {
        List<CarDto> list = carService.getAll();
        model.addAttribute("cars", list);
        return "cars";
    }

    @GetMapping("/{id}/clientOrder")
    public String addOrder(@PathVariable Integer id, Principal principal) {
        if(principal == null) {
            return "redirect:/cars";
        }
        carService.addToOrder(id, principal.getName());
        return "redirect:/cars";
    }

    @GetMapping("/new")
    public String newCar(Model model){
        model.addAttribute("car", new CarDto());
        return "car";
    }

    @PostMapping("/new")
    public String saveCar(CarDto carDto, Model model){
        if (carService.save(carDto)) {
            return "redirect:/cars";
        } else {
            model.addAttribute("car", carDto);
        }
        return "car";
    }
}
