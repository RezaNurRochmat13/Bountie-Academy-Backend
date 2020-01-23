package com.backend.bountieacademy.modules.v1.students.dao;

import com.backend.bountieacademy.modules.v1.utils.persistence.AuditModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class StudentDao extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentId;

    @Column(name = "name")
    private String studentName;

    @Column(name = "gender")
    private String studentGender;

    @Column(name = "address")
    private String studentAddress;
}
