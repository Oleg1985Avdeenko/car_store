package com.example.car_store.entity.cars;

import com.example.car_store.entity.users.ClientOrder;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String model;

    @Column
    private BigDecimal price;

    @Column
    private Boolean availability;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "engine_id", nullable = false)
    private Engine carEngine;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "color_id", nullable = false)
    private Color carColor;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "transmission_id", nullable = false)
    private Transmission carTransmission;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_option_id", nullable = false)
    private ModelOption carOption;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private ClientOrder selectedCar;

}
