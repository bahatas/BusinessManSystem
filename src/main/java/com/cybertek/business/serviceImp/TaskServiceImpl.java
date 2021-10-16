package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.dto.TaskDTO;
import com.cybertek.business.entity.Task;
import com.cybertek.business.enums.Status;
import com.cybertek.business.mapper.MapperUtil;
import com.cybertek.business.repository.ProjectRepository;
import com.cybertek.business.repository.TaskRepository;
import com.cybertek.business.repository.UserRepository;
import com.cybertek.business.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public List<TaskDTO> listAllTasks() {
        List<Task> all = taskRepository.findAll();
        return all.stream()
                .map(each -> mapperUtil.convert(each, new TaskDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO findById(Long id) {
        Task task = taskRepository.findById(id).get();

        return mapperUtil.convert(task, new TaskDTO());
    }

    @Override
    public void save(TaskDTO taskDTO) {

        Task taskEntity = mapperUtil.convert(taskDTO, new Task());

        taskEntity.setTaskStatus(Status.OPEN);
        taskEntity.setAssignedDate(LocalDate.now());
        taskRepository.save(taskEntity);

    }

    @Override
    public void delete(Long id) {

        Task task = taskRepository.findById(id).get();

        task.setIsDeleted(true);

        taskRepository.save(task);
    }

    @Override
    public void update(TaskDTO taskDTO) {

        Task taskToUpdate = taskRepository.findById(taskDTO.getId()).get();

        taskToUpdate.setAssignedDate(LocalDate.now());
        taskRepository.save(taskToUpdate);

    }

    @Override
    public int totalNonCompletedTasks(String projectCode) {
        List<Task> allByTaskStatusIsNot = taskRepository.findAllByTaskStatusIsNot(Status.COMPLETE);

        return allByTaskStatusIsNot.size();
    }

    @Override
    public int totalCompletedTask(String projectCode) {
        return (int) taskRepository.findAll().stream().filter(each ->
                each.getTaskStatus() == Status.COMPLETE).count();
    }

    @Override
    public List<TaskDTO> listAllByProject(ProjectDTO projectDTO) {
        return null;
    }

    @Override
    public List<TaskDTO> listAllTasksBySttatusIsNot(Status status) {
        return taskRepository.findAllByTaskStatusIsNot(Status.COMPLETE).stream()
                .map(each->mapperUtil.convert(each,new TaskDTO()))
                .collect(Collectors.toList());
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
