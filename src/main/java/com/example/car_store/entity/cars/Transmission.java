package com.example.car_store.entity.cars;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column
    private String type;

    @OneToMany(mappedBy = "carTransmission", cascade = CascadeType.ALL)
    private Set<Car> selectedTransmissions = new HashSet<>();

}
