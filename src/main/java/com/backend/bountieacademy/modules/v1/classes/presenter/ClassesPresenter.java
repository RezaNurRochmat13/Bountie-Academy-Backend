package com.backend.bountieacademy.modules.v1.classes.presenter;

import com.backend.bountieacademy.modules.v1.classes.dao.ClassesDao;
import com.backend.bountieacademy.modules.v1.classes.usecase.ClassesUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/")
public class ClassesPresenter {
    @Autowired
    ClassesUseCaseImpl classesUseCase;

    @GetMapping("classes")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllClasses() {
        Map<String, Object> map = new HashMap<>();
        List<ClassesDao> classesDaoList = classesUseCase.findAllClasses();
        Long classesTotal = classesUseCase.countAllClasses();
        map.put("total", classesTotal);
        map.put("count", classesDaoList.size());
        map.put("data", classesDaoList);
        return map;
    }

    @GetMapping("class/{classesId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getSingleClasses(@PathVariable Long classesId) {
        Map<String, Object> map = new HashMap<>();
        Optional<ClassesDao> classesDaoOptional = classesUseCase.findByClassesId(classesId);
        map.put("data", classesDaoOptional);
        return map;
    }

    @PostMapping("class")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> createNewClass(@RequestBody ClassesDao classesDaoPayload) {
        Map<String, Object> map = new HashMap<>();
        ClassesDao classesDaos = classesUseCase.createNewClasses(classesDaoPayload);
        map.put("message", "Class created successfully");
        map.put("created_data", classesDaos);
        return map;
    }

    @PutMapping("class/{classId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> updateClass(@PathVariable Long classId,
                                           @RequestBody ClassesDao classesDaoPayload) {
        Map<String, Object> map = new HashMap<>();
        ClassesDao classesDao = classesUseCase.updateClasses(classId, classesDaoPayload);
        map.put("message", "Class updated successfully");
        map.put("updated_data", classesDao);
        return map;

    }

    @DeleteMapping("class/{classId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> deleteClass(@PathVariable Long classId) {
        Map<String, Object> map = new HashMap<>();
        ClassesDao classesDao = classesUseCase.deleteClasses(classId);
        map.put("message", "Class deleted successfully");
        map.put("deleted_data", classesDao);
        return map;
    }
}
