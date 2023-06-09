package com.example.car_store.service;

import com.example.car_store.dao.CarRepository;
import com.example.car_store.dao.OrderRepository;
import com.example.car_store.entity.cars.Car;
import com.example.car_store.entity.users.ClientOrder;
import com.example.car_store.entity.users.User;
import com.example.car_store.mapper.CarMapper;
import com.example.car_store.service.dto.CarDto;
import com.example.car_store.service.dto.OrderDetailDto;
import com.example.car_store.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    private final UserService userService;


    public List<Car> getCollectCarById(List<Integer> carIdList) {
        return carIdList.stream().map(carRepository::getOne)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClientOrder createOrder(User user, List<Integer> carIdList) {
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setUser(user);
        List<Car> carList = getCollectCarById(carIdList);
        clientOrder.setSelectedCars(carList);
        return orderRepository.save(clientOrder);
    }

    @Override
    public List<CarDto> addCar(ClientOrder order, List<Integer> carIdList) {
        List<Car> carList = order.getSelectedCars();
        List<Car> newCarList = carList == null ? new ArrayList<>() : new ArrayList<>(carList);
        newCarList.addAll(getCollectCarById(carIdList));
        order.setSelectedCars(newCarList);
        orderRepository.save(order);
        List<CarDto> dtoCarList = newCarList.stream().map(carMapper::toDto).collect(Collectors.toList());
        return dtoCarList;
    }

    @Override
    public List<CarDto> deleteCar(String login, Integer carId) {
        User user = userService.findByLogin(login);
        List<Car> carList = user.getClientOrder().getSelectedCars();
        Car car = carRepository.getOne(carId);
        carList.remove(car);
        ClientOrder order = user.getClientOrder();
        order.setSelectedCars(carList);
        orderRepository.save(order);
        List<CarDto> dtoCarList = carList.stream().map(carMapper::toDto).collect(Collectors.toList());
        return dtoCarList;
    }

    @Override
    public OrderDto getUsersOrder(String login) {
        User user = userService.findByLogin(login);
        if (user == null || user.getClientOrder() == null) {
            return new OrderDto();
        }
        OrderDto orderDto = new OrderDto();
        Map<Integer, OrderDetailDto> mapByCarId = new HashMap<>();
        List<Car> cars = user.getClientOrder().getSelectedCars();
        for (Car car : cars) {
            OrderDetailDto detailDto = mapByCarId.get(car.getId());
            if (detailDto == null) {
                mapByCarId.put(car.getId(), new OrderDetailDto(car));
            } else {
                detailDto.setAmount(detailDto.getAmount().add(new BigDecimal(1.0)));
                detailDto.setSum(detailDto.getSum() + Double.valueOf(car.getPrice().toString()));
            }
        }
        orderDto.setOrderDetails(new ArrayList<>(mapByCarId.values()));
        orderDto.aggregate();
        return orderDto;
    }
}
