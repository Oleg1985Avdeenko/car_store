package com.example.car_store.controllers;

import com.example.car_store.dao.OrderRepository;
import com.example.car_store.entity.cars.Car;
import com.example.car_store.entity.users.ClientOrder;
import com.example.car_store.entity.users.User;
import com.example.car_store.mapper.CarMapper;
import com.example.car_store.service.CarService;
import com.example.car_store.service.dto.CarDto;
import com.example.car_store.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper mapper1;

    @GetMapping
    public String list(Model model) {
        List<CarDto> list = carService.getAll();
        model.addAttribute("cars", list);
        return "cars";
    }

    @GetMapping("/{id}/clientOrder")
    public String addOrder(@PathVariable Integer id, Principal principal) {
        if (principal == null) {
            return "redirect:/cars";
        }
        carService.addToOrder(id, principal.getName());
        return "redirect:/cars";
    }

    @GetMapping("/new")
    public String newCar(Model model) {
        CarDto carDto = new CarDto();
        model.addAttribute("car", carDto);
        return "car";
    }

    @PostMapping("/new")
    public String saveCar(CarDto carDto, Model model) {
        System.out.println("==============================");
        System.out.println(carDto);
        if (carService.save(carDto)) {
            return "redirect:/cars";
        } else {
            model.addAttribute("car", carDto);
        }
        return "car";
    }

    @GetMapping("/{id}/update")
    public String profileCar(Model model, @PathVariable Integer id) {
        CarDto carDto = carService.findById(id);
        model.addAttribute("car", carDto);
        return "updateCar";
    }

    @PostMapping("/{car}/update")
    public String update(CarDto carDto) {
        carService.updateCar(carDto);
        return "redirect:/cars";
    }
    @GetMapping("/{id}/delete")
    public String deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
