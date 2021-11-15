package ru.ibs.springbootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.springbootCRUD.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
