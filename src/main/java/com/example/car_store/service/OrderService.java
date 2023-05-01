package com.example.car_store.service;

import com.example.car_store.entity.users.ClientOrder;
import com.example.car_store.entity.users.User;
import com.example.car_store.service.dto.OrderDto;

import java.util.List;

public interface OrderService {

    ClientOrder createOrder(User user, List<Integer> carIdList);

    void addCar(ClientOrder order, List<Integer> carIdList);

    OrderDto getUsersOrder(String login);
}
