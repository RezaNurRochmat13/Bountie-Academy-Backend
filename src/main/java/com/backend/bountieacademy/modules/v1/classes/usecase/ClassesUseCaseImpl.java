package com.backend.bountieacademy.modules.v1.classes.usecase;

import com.backend.bountieacademy.modules.v1.classes.dao.ClassesDao;
import com.backend.bountieacademy.modules.v1.classes.repository.ClassesRepository;
import com.backend.bountieacademy.modules.v1.utils.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesUseCaseImpl implements ClassesUseCase {
    @Autowired
    ClassesRepository classesRepository;

    @Override
    public List<ClassesDao> findAllClasses() {
        return classesRepository.findAll();
    }

    @Override
    public Long countAllClasses() {
        return classesRepository.count();
    }

    @Override
    public Optional<ClassesDao> findByClassesId(Long classesId) {
        Optional<ClassesDao> classesDaoOptional = Optional.ofNullable(classesRepository
                .findById(classesId)
                .orElseThrow(() -> new ResourceNotFound("Classes not found with id : " + classesId)));

        return classesDaoOptional;
    }

    @Override
    public ClassesDao createNewClasses(ClassesDao classesDaoPayload) {
        return classesRepository.save(classesDaoPayload);
    }

    @Override
    public ClassesDao updateClasses(Long classesId, ClassesDao classesDaoPayload) {
        ClassesDao classesDao = classesRepository.findById(classesId)
                .orElseThrow(() -> new ResourceNotFound("Classes not found with id : " + classesId));

        classesDao.setClassName(classesDaoPayload.getClassName());
        classesDao.setClassQuota(classesDaoPayload.getClassQuota());
        classesDao.setClassDuration(classesDaoPayload.getClassDuration());
        classesRepository.save(classesDao);

        return classesDao;
    }

    @Override
    public ClassesDao deleteClasses(Long classesId) {
        ClassesDao classesDao = classesRepository.findById(classesId)
                .orElseThrow(() -> new ResourceNotFound("Classes not found with id : " + classesId));

        classesRepository.delete(classesDao);
        return classesDao;
    }
}
