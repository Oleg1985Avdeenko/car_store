package com.example.car_store.controllers;

import com.example.car_store.service.OrderService;
import com.example.car_store.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/clientOrder")
    public String aboutOrder(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("clientOrder", new OrderDto());
        } else {
            OrderDto orderDto = orderService.getUsersOrder(principal.getName());
            model.addAttribute("clientOrder", orderDto);
        }
        return "clientOrder";
    }

    @PostMapping("/clientOrder")
    public String deleteFromOrder(Model model, Principal principal, @PathVariable Integer id) {
        OrderDto orderDto = orderService.getUsersOrder(principal.getName());
        orderService.deleteCar(principal.getName(), id);
        model.addAttribute("clientOrder", orderDto);

        return "clientOrder";
    }
}
