package com.backend.bountieacademy.modules.v1.classes.dao;

import com.backend.bountieacademy.modules.v1.utils.persistence.AuditModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class ClassesDao extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long classId;

    @Column(name = "name")
    private String className;

    @Column(name = "quota")
    private Integer classQuota;

    @Column(name = "duration")
    private Integer classDuration;
}
