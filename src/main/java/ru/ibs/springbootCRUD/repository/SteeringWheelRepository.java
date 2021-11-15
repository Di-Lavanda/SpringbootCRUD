package ru.ibs.springbootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.springbootCRUD.model.SteeringWheel;

public interface SteeringWheelRepository extends JpaRepository<SteeringWheel, Long> {
}
