package com.example.car_store.controllers;

import com.example.car_store.dao.OrderRepository;
import com.example.car_store.entity.cars.Car;
import com.example.car_store.entity.users.ClientOrder;
import com.example.car_store.mapper.CarMapper;
import com.example.car_store.service.CarService;
import com.example.car_store.service.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper mapper1;
    private final OrderRepository orderRepository;

    private  Random random = new Random();
    @GetMapping
    public String list(Model model) {
        List<CarDto> list = carService.getAll();
        List<ClientOrder> clientOrders = orderRepository.findAll();
        for (ClientOrder order : clientOrders) {
            List<Car> carList = order.getSelectedCars();
            list.removeAll(carList.stream().map(mapper1::toCarDto).collect(Collectors.toList()));
        }
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
        if (carService.save(carDto)) {
            return "redirect:/cars";
        } else {
            model.addAttribute("car", carDto);
        }
        return "car";
    }
}
