package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.entity.Project;
import com.cybertek.business.mapper.MapperUtil;
import com.cybertek.business.repository.ProjectRepository;
import com.cybertek.business.service.ProjectService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {


    private ProjectRepository projectRepository;
    private MapperUtil mapperUtil;


    public ProjectServiceImpl(ProjectRepository projectRepository, MapperUtil mapperUtil) {
        this.projectRepository = projectRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public ProjectDTO getByProjectCode(String projectCode) {

        return null;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream().map(each->mapperUtil.convert(each, new ProjectDTO())).collect(Collectors.toList());
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
