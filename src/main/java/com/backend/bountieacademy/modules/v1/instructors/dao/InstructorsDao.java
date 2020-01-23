package com.backend.bountieacademy.modules.v1.instructors.dao;

import com.backend.bountieacademy.modules.v1.utils.persistence.AuditModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class InstructorsDao extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long instructorId;

    @Column(name = "name")
    private String instructorName;

    @Column(name = "proficiency")
    private String instructorProficiency;
}
