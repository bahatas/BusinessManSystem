package com.cybertek.business.dto;


import com.cybertek.business.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private Long id;
    private ProjectDTO projectDTO;
    private UserDTO userDTO;
    private String taskSubject;
    private String taskDetail;

    private Status taskStatus;

    private LocalDate assignedDate;
}
