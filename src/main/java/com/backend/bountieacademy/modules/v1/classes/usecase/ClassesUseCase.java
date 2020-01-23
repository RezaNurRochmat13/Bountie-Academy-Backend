package com.backend.bountieacademy.modules.v1.classes.usecase;

import com.backend.bountieacademy.modules.v1.classes.dao.ClassesDao;

import java.util.List;
import java.util.Optional;

public interface ClassesUseCase {
    List<ClassesDao> findAllClasses();
    Long countAllClasses();
    Optional<ClassesDao> findByClassesId(Long classesId);
    ClassesDao createNewClasses(ClassesDao classesDaoPayload);
    ClassesDao updateClasses(Long classesId, ClassesDao classesDaoPayload);
    ClassesDao deleteClasses(Long classesId);
}
