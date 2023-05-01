package com.example.car_store.entity.cars;

import javax.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String colorName;

    @OneToMany(mappedBy = "carColor", cascade = CascadeType.PERSIST)
    private Set<Car> selectedColors = new HashSet<>();

}
