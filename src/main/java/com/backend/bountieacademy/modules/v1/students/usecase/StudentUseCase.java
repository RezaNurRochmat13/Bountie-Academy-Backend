package com.backend.bountieacademy.modules.v1.students.usecase;

import com.backend.bountieacademy.modules.v1.students.dao.StudentDao;

import java.util.List;
import java.util.Optional;

public interface StudentUseCase {
    List<StudentDao> findAllStudents();
    Long countAllStudents();
    Optional<StudentDao> findByStudentId(Long studentId);
    StudentDao createNewStudent(StudentDao studentDaoPayload);
    StudentDao updateStudent(Long studentId, StudentDao studentDaoPayload);
    StudentDao deleteStudent(Long studentId);
}
