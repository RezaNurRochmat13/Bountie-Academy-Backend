package com.backend.bountieacademy.modules.v1.students.repository;

import com.backend.bountieacademy.modules.v1.students.dao.StudentDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDao, Long> {
}
