package com.backend.bountieacademy.modules.v1.instructors.usecase;

import com.backend.bountieacademy.modules.v1.instructors.dao.InstructorsDao;

import java.util.List;
import java.util.Optional;

public interface InstructorUseCase {
    List<InstructorsDao> findAllInstructors();
    Long countAllInstructor();
    Optional<InstructorsDao> findByInstructorId(Long instructorId);
    InstructorsDao createNewInstructor(InstructorsDao instructorsDaoPayload);
    InstructorsDao updateInstructor(Long instructorId, InstructorsDao instructorsDaoPayload);
    InstructorsDao deleteInstructor(Long instructorId);
}
