package com.cybertek.business.repository;

import com.cybertek.business.entity.Task;
import com.cybertek.business.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {


    List<Task> findAllByTaskStatusIsNot(Status status);
}
