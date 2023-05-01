package com.example.car_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CarStoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CarStoreApplication.class, args);
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        System.out.println(encoder.encode("56789"));
       // SpringApplication.run(CarStoreApplication.class, args);
    }

}
