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
        Optional<Task> byId = taskRepository.findById(id);

        return mapperUtil.convert(byId, new TaskDTO());
    }

    @Override
    public void save(TaskDTO taskDTO) {

        Task taskEntity = mapperUtil.convert(taskDTO, new Task());

        taskEntity.setTaskStatus(Status.OPEN);
        taskEntity.setAssigedDate(LocalDateTime.now());
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
