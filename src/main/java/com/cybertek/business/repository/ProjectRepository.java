package com.cybertek.business.repository;

import com.cybertek.business.entity.Project;
import com.cybertek.business.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {



    Project findByProjectCode(String projectCode);


    List<Project> findByAssignedManager_UserName  (String username);

    List<Project> findAllByStatusIsNot (Status status);






}
