package com.backend.bountieacademy.modules.v1.students.usecase;

import com.backend.bountieacademy.modules.v1.students.dao.StudentDao;
import com.backend.bountieacademy.modules.v1.students.repository.StudentRepository;
import com.backend.bountieacademy.modules.v1.utils.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentUseCaseImpl implements StudentUseCase {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentDao> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Long countAllStudents() {
        return studentRepository.count();
    }

    @Override
    public Optional<StudentDao> findByStudentId(Long studentId) {
        Optional<StudentDao> studentDao = Optional.ofNullable(studentRepository
                .findById(studentId)
                .orElseThrow(() -> new ResourceNotFound("Student not found with id : " + studentId)));

        return studentDao;
    }

    @Override
    public StudentDao createNewStudent(StudentDao studentDaoPayload) {
        return studentRepository.save(studentDaoPayload);
    }

    @Override
    public StudentDao updateStudent(Long studentId, StudentDao studentDaoPayload) {
        StudentDao studentDao = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new ResourceNotFound("Student not found with id : " + studentId));

        studentDao.setStudentName(studentDaoPayload.getStudentName());
        studentDao.setStudentGender(studentDaoPayload.getStudentGender());
        studentDao.setStudentAddress(studentDaoPayload.getStudentAddress());
        studentRepository.save(studentDao);
        return studentDao;
    }

    @Override
    public StudentDao deleteStudent(Long studentId) {
        StudentDao studentDao = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new ResourceNotFound("Student not found with id : " + studentId));
        studentRepository.delete(studentDao);

        return studentDao;
    }
}
