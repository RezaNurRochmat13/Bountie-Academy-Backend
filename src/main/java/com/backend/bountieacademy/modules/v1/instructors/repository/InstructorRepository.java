package com.backend.bountieacademy.modules.v1.instructors.repository;

import com.backend.bountieacademy.modules.v1.instructors.dao.InstructorsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorsDao, Long> {
}
