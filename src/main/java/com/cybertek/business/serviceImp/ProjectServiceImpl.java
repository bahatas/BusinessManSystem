package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.entity.Project;
import com.cybertek.business.enums.Status;
import com.cybertek.business.mapper.MapperUtil;
import com.cybertek.business.repository.ProjectRepository;
import com.cybertek.business.service.ProjectService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    public void save(ProjectDTO projectDTO) {


        Project convert = mapperUtil.convert(projectDTO, new Project());
        convert.setInsertUserId(1L);//todo
        convert.setLastUpdateUserId(1L);//todo
        convert.setLastUpdateDateTime(LocalDateTime.now());
        convert.setStatus(Status.OPEN);


        projectRepository.save(convert);



    }

    @Override
    public void update(ProjectDTO projectDTO) {

        Project project = projectRepository.findByProjectCode(projectDTO.getProjectCode());
        mapperUtil.convert(projectDTO, convertedToEntity);

        project.setLastUpdateDateTime(LocalDateTime.now());
        project.setLastUpdateUserId(1L); // todo after security implementation

        projectRepository.save(project);

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
