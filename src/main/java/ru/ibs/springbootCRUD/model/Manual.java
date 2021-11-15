package ru.ibs.springbootCRUD.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "manual")
public class Manual {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;

}