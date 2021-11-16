package ru.ibs.springbootCRUD.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "model")
    private String model;
    @OneToOne(cascade = CascadeType.ALL)
    private Engine engine;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Gear> gear;
    @OneToOne(cascade = CascadeType.ALL)
    private Manual manual;
    @OneToOne(cascade = CascadeType.ALL)
    private SteeringWheel steeringWheel;
}
