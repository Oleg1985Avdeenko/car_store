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
public class ModelOption {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column
    private String optionName;

    @Column
    private String salon;

    @Column
    private Boolean heatedSeat;

    @Column
    private Boolean cruiseControl;

    @Column
    private Boolean steeringWheelControl;

    @Column
    private Boolean fogLight;

    @OneToMany(mappedBy = "carOption", cascade = CascadeType.ALL)
    private Set<Car> selectedOptions = new HashSet<>();

}
