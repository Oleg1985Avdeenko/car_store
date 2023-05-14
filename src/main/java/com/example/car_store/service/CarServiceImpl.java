package com.example.car_store.service;

import com.example.car_store.dao.CarRepository;
import com.example.car_store.dao.OrderRepository;
import com.example.car_store.dao.UserRepository;
import com.example.car_store.entity.cars.Car;
import com.example.car_store.entity.users.ClientOrder;
import com.example.car_store.entity.users.User;
import com.example.car_store.mapper.CarMapper;
import com.example.car_store.service.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarMapper mapper;

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;


    @Override
    public List<CarDto> getAll() {
        List<CarDto> list = carRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        List<ClientOrder> clientOrders = orderRepository.findAll();
        for (ClientOrder order : clientOrders) {
            List<Car> carList = order.getSelectedCars();
            list.removeAll(carList.stream().map(mapper::toDto).collect(Collectors.toList()));
        }
        return list;
    }

    @Override
    @Transactional
    public void addToOrder(Integer carId, String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new RuntimeException("User not found " + login);
        }
        ClientOrder order = user.getClientOrder();
        if (order == null) {
            ClientOrder newOrder = orderService.createOrder(user, Collections.singletonList(carId));
            user.setClientOrder(newOrder);
            userRepository.save(user);
        } else {
            orderService.addCar(order, Collections.singletonList(carId));
            getAll();
        }
    }

    @Override
    public boolean save(CarDto carDto) {
        Car car = mapper.toEntity(carDto);
        carRepository.save(car);
        return true;
    }

    @Override
    public CarDto findById(Integer id) {
        Car car = carRepository.getById(id);
        CarDto carDto = mapper.toDto(car);
       return carDto;
    }

    @Override
    public void updateCar(CarDto carDto) {
        CarDto savedCar = findById(carDto.getId());

        if (savedCar == null) {
            throw new RuntimeException("Car not found by id " + carDto.getId());
        }
        boolean isChanged = false;
        if (!Objects.equals(carDto.getModel(), savedCar.getModel())) {
            savedCar.setModel(carDto.getModel());
            isChanged = true;
        }
        if (!Objects.equals(carDto.getPrice(), savedCar.getPrice())) {
            savedCar.setPrice(carDto.getPrice());
            isChanged = true;
        }
        if (!Objects.equals(carDto.getAvailability(), savedCar.getAvailability())) {
            savedCar.setAvailability(carDto.getAvailability());
            isChanged = true;
        }
        if (!Objects.equals(carDto.getCarEngine(), savedCar.getCarEngine())) {
            savedCar.setCarEngine(carDto.getCarEngine());
            isChanged = true;
        }
        if (!Objects.equals(carDto.getCarColor(), savedCar.getCarColor())) {
            savedCar.setCarColor(carDto.getCarColor());
            isChanged = true;
        }
        if (!Objects.equals(carDto.getCarTransmission(), savedCar.getCarTransmission())) {
            savedCar.setCarTransmission(carDto.getCarTransmission());
            isChanged = true;
        }
        if (!Objects.equals(carDto.getCarOption(), savedCar.getCarOption())) {
            savedCar.setCarOption(carDto.getCarOption());
            isChanged = true;
        }
        if (isChanged) {
            Car car = mapper.toEntity(savedCar);
            carRepository.save(car);
        }
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }


}



