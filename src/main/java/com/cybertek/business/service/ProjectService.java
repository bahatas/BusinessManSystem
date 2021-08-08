package com.cybertek.business.service;


import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    ProjectDTO getByProjectCode(String projectCode);

    List<ProjectDTO> listAllProjects();

    Project save(ProjectDTO projectDTO);

    void update( ProjectDTO projectDTO);

    void delete ( String projectCode);

    void complete(String projectCode);

    List<ProjectDTO> readAllByAssignedManager();
    List<ProjectDTO> readAllProjectDetails();
    List<ProjectDTO> listNonCompletedProjects();

}
