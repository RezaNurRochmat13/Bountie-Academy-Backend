package com.backend.bountieacademy.modules.v1.classes.repository;

import com.backend.bountieacademy.modules.v1.classes.dao.ClassesDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<ClassesDao, Long> {
}
