package com.cybertek.business.service;

import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.dto.TaskDTO;
import com.cybertek.business.entity.Task;
import com.cybertek.business.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDTO> listAllTasks();
    TaskDTO findById(Long id);
    Task save(TaskDTO taskDTO);
    void delete(Long id);
    void update(TaskDTO taskDTO);

    int totalNonCompletedTasks(String projectCode);
    int totalCompletedTask(String projectCode);

    List<TaskDTO> listAllByProject(ProjectDTO projectDTO);

    List<TaskDTO> listAllTasksBySttatusIsNot(Status status);

    List<TaskDTO> listAllTasksByStatus(Status status);

    void updateStatus(TaskDTO taskDTO);

    List<TaskDTO> readAllByEmployee();


}
