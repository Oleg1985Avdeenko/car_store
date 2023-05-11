package com.example.car_store.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Integer id;
    private Integer amountCars;
    private double sum;

    private List<OrderDetailDto> orderDetails = new ArrayList<>();

    public void aggregate() {
        this.amountCars = orderDetails.size();
        this.sum = orderDetails.stream()
                .map(OrderDetailDto::getSum)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
