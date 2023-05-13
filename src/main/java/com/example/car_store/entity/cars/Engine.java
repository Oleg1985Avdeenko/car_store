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
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column
    private Double volume;

    @Column
    private String type;

    @OneToMany(mappedBy = "carEngine", cascade = CascadeType.ALL)
    private Set<Car> selectedEngines = new HashSet<>();

}
