package ru.ibs.springbootCRUD.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="engines")
public class Engine {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "model")
    private String model;
}
