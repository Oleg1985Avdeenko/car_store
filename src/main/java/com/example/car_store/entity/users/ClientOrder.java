package com.example.car_store.entity.users;

import com.example.car_store.entity.cars.Car;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Car> selectedCars = new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
