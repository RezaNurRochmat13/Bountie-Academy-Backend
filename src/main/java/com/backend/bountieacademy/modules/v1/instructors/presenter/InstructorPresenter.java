package com.backend.bountieacademy.modules.v1.instructors.presenter;

import com.backend.bountieacademy.modules.v1.instructors.dao.InstructorsDao;
import com.backend.bountieacademy.modules.v1.instructors.usecase.InstructorUseCaseImpl;
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
public class InstructorPresenter {
    @Autowired
    InstructorUseCaseImpl instructorUseCase;

    @GetMapping("instructors")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllInstructors() {
        Map<String, Object> map = new HashMap<>();
        List<InstructorsDao> instructorsDaos = instructorUseCase.findAllInstructors();
        Long countAllInstructor = instructorUseCase.countAllInstructor();
        map.put("total", countAllInstructor);
        map.put("count", instructorsDaos.size());
        map.put("data", instructorsDaos);
        return map;
    }

    @GetMapping("instructor/{instructorId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getSingleInstructor(@PathVariable Long instructorId) {
        Map<String, Object> map = new HashMap<>();
        Optional<InstructorsDao> instructorsDao = instructorUseCase
                .findByInstructorId(instructorId);
        map.put("data", instructorsDao);
        return map;
    }

    @PostMapping("instructor")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> createNewInstructor(@RequestBody InstructorsDao instructorsDaoPayload) {
        Map<String, Object> map = new HashMap<>();
        InstructorsDao instructorsDao = instructorUseCase.createNewInstructor(instructorsDaoPayload);
        map.put("message", "Instructor created successfully");
        map.put("created_data", instructorsDao);
        return map;
    }

    @PutMapping("instructor/{instructorId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> updateInstructor(@PathVariable Long instructorId,
                                                @RequestBody InstructorsDao instructorsDaoPayload) {
        Map<String, Object> map = new HashMap<>();
        InstructorsDao instructorsDao = instructorUseCase
                .updateInstructor(instructorId, instructorsDaoPayload);
        map.put("message", "Instructor updated successfully");
        map.put("updated_data", instructorsDao);
        return map;
    }

    @DeleteMapping("instructor/{instructorId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> deleteInstructor(@PathVariable Long instructorId) {
        Map<String, Object> map = new HashMap<>();
        InstructorsDao instructorsDao = instructorUseCase
                .deleteInstructor(instructorId);
        map.put("message", "Instructor deleted successfully");
        map.put("deleted_data", instructorsDao);
        return map;
    }
}
