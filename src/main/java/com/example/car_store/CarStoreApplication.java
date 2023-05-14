package com.example.car_store;

import com.example.car_store.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarStoreApplication {
    static CarService carService;

    public static void main(String[] args) {
        SpringApplication.run(CarStoreApplication.class, args);
    }

}
