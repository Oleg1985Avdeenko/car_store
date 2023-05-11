package com.example.car_store.dao;

import com.example.car_store.entity.cars.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
}
