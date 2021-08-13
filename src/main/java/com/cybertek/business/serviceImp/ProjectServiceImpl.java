package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.entity.Project;
import com.cybertek.business.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ProjectDTO getByProjectCode(String projectCode) {

        return null;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        return null;
    }

    @Override
    public Project save(ProjectDTO projectDTO) {
        return null;
    }

    @Override
    public void update(ProjectDTO projectDTO) {

    }

    @Override
    public void delete(String projectCode) {

    }

    @Override
    public void complete(String projectCode) {

    }

    @Override
    public List<ProjectDTO> readAllByAssignedManager() {
        return null;
    }

    @Override
    public List<ProjectDTO> readAllProjectDetails() {
        return null;
    }

    @Override
    public List<ProjectDTO> listNonCompletedProjects() {
        return null;
    }
}
