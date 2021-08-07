package com.cybertek.business.entity;

import com.cybertek.business.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="projectsTable")
public class Project extends BaseEntity {

    private String projectName;

    private String projectCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id")
    private User assignedManager;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate projectDetail;

    private Status status;


}
