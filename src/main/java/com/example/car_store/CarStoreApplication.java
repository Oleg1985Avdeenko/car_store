package com.example.car_store;

import com.example.car_store.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarStoreApplication {
    static CarService carService;

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(CarStoreApplication.class, args);
//        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
//        System.out.println(encoder.encode("12345"));
        SpringApplication.run(CarStoreApplication.class, args);
    }

}
