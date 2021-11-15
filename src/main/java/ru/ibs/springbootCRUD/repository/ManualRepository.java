package ru.ibs.springbootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.springbootCRUD.model.Manual;

public interface ManualRepository extends JpaRepository<Manual, Long> {
}
