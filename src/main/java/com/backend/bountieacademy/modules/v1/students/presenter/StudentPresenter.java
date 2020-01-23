package com.backend.bountieacademy.modules.v1.students.presenter;

import com.backend.bountieacademy.modules.v1.students.dao.StudentDao;
import com.backend.bountieacademy.modules.v1.students.usecase.StudentUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
public class StudentPresenter {
    @Autowired
    StudentUseCaseImpl studentUseCase;

    @GetMapping("students")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllStudents() {
        Map<String, Object> map = new HashMap<>();
        List<StudentDao> studentDaos = studentUseCase.findAllStudents();
        Long countAllStudent = studentUseCase.countAllStudents();
        map.put("total", countAllStudent);
        map.put("count", studentDaos.size());
        map.put("data", studentDaos);
        return map;
    }

    @GetMapping("student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getSingleStudent(@PathVariable Long studentId) {
        Map<String, Object> map = new HashMap<>();
        Optional<StudentDao> studentDao = studentUseCase
                .findByStudentId(studentId);
        map.put("data", studentDao);
        return map;
    }

    @PostMapping("student")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> createNewStudent(@RequestBody StudentDao studentDaoPayload) {
        Map<String, Object> map = new HashMap<>();
        StudentDao studentDao = studentUseCase.createNewStudent(studentDaoPayload);
        map.put("message", "Student created successfully");
        map.put("created_data", studentDao);
        return map;
    }

    @PutMapping("student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> updateStudent(@PathVariable Long studentId,
                                             @RequestBody StudentDao studentDaoPayload) {
        Map<String, Object> map = new HashMap<>();
        StudentDao studentDao = studentUseCase.updateStudent(studentId, studentDaoPayload);
        map.put("message", "Student updated successfully");
        map.put("updated_data", studentDao);
        return map;

    }

    @DeleteMapping("student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> deleteStudent(@PathVariable Long studentId) {
        Map<String, Object> map = new HashMap<>();
        StudentDao studentDao = studentUseCase.deleteStudent(studentId);
        map.put("message", "Student deleted successfully");
        map.put("deleted_data", studentDao);
        return map;
    }
}
