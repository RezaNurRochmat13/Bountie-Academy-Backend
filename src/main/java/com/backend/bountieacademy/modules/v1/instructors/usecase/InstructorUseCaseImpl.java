package com.backend.bountieacademy.modules.v1.instructors.usecase;

import com.backend.bountieacademy.modules.v1.instructors.dao.InstructorsDao;
import com.backend.bountieacademy.modules.v1.instructors.repository.InstructorRepository;
import com.backend.bountieacademy.modules.v1.utils.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorUseCaseImpl implements InstructorUseCase {
    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public List<InstructorsDao> findAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Long countAllInstructor() {
        return instructorRepository.count();
    }

    @Override
    public Optional<InstructorsDao> findByInstructorId(Long instructorId) {
        Optional<InstructorsDao> instructorsDao = Optional.ofNullable(instructorRepository
                .findById(instructorId)
                .orElseThrow(() -> new ResourceNotFound("Instructor not found with id : " + instructorId)));

        return instructorsDao;
    }

    @Override
    public InstructorsDao createNewInstructor(InstructorsDao instructorsDaoPayload) {
        return instructorRepository.save(instructorsDaoPayload);
    }

    @Override
    public InstructorsDao updateInstructor(Long instructorId, InstructorsDao instructorsDaoPayload) {
        InstructorsDao instructorsDao = instructorRepository
                .findById(instructorId)
                .orElseThrow(() -> new ResourceNotFound("Instructor not found with id : " + instructorId));

        instructorsDao.setInstructorName(instructorsDaoPayload.getInstructorName());
        instructorsDao.setInstructorProficiency(instructorsDaoPayload.getInstructorProficiency());
        instructorRepository.save(instructorsDao);

        return instructorsDao;
    }

    @Override
    public InstructorsDao deleteInstructor(Long instructorId) {
        InstructorsDao instructorsDao = instructorRepository
                .findById(instructorId)
                .orElseThrow(() -> new ResourceNotFound("Instructor not found with id : " + instructorId));
        instructorRepository.delete(instructorsDao);

        return instructorsDao;
    }
}
