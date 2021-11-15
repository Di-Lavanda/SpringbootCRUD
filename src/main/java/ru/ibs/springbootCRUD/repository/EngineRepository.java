package ru.ibs.springbootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.springbootCRUD.model.Engine;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
