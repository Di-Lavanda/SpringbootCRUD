package ru.ibs.springbootCRUD.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "steering_wheels")
public class SteeringWheel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "type")
    private String type;

}
