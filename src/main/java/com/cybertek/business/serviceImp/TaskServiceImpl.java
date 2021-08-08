package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.dto.TaskDTO;
import com.cybertek.business.entity.Task;
import com.cybertek.business.enums.Status;
import com.cybertek.business.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public List<TaskDTO> listAllTasks() {
        return null;
    }

    @Override
    public TaskDTO findById(Long id) {
        return null;
    }

    @Override
    public Task save(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(TaskDTO taskDTO) {

    }

    @Override
    public int totalNonCompletedTasks(String projectCode) {
        return 0;
    }

    @Override
    public int totalCompletedTask(String projectCode) {
        return 0;
    }

    @Override
    public List<TaskDTO> listAllByProject(ProjectDTO projectDTO) {
        return null;
    }

    @Override
    public List<TaskDTO> listAllTasksBySttatusIsNot(Status status) {
        return null;
    }

    @Override
    public List<TaskDTO> listAllTasksByStatus(Status status) {
        return null;
    }

    @Override
    public void updateStatus(TaskDTO taskDTO) {

    }

    @Override
    public List<TaskDTO> readAllByEmployee() {
        return null;
    }
}
