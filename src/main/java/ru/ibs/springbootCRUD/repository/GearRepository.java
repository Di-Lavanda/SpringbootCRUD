package ru.ibs.springbootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.springbootCRUD.model.Gear;

public interface GearRepository extends JpaRepository<Gear, Long> {
}
