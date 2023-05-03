package com.example.car_store.entity.users;

import com.example.car_store.entity.cars.Car;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

//    @CreationTimestamp
//    private LocalDateTime timeOfCreation;
//
//    @UpdateTimestamp
//    private LocalDateTime timeOfUpdate;
//
//    @Enumerated(EnumType.STRING)
//    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Car> selectedCars = new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
