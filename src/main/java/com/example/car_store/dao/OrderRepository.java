package com.example.car_store.dao;

import com.example.car_store.entity.users.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ClientOrder, Integer> {
}
