package com.cybertek.business.entity;


import com.cybertek.business.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Task extends BaseEntity{


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private User assignedEmployee;


    private String taskSubject;

    private String taskDetail;

    @Enumerated(EnumType.STRING)
    private Status taskStatus;

    private LocalDateTime assigedDate;


}
