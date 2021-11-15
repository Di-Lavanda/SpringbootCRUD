package ru.ibs.springbootCRUD.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gear")
public class Gear {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "type")
    private String type;


}
