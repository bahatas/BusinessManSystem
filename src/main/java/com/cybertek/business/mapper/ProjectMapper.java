package com.cybertek.business.mapper;

import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    @Autowired
    ModelMapper modelMapper;

    public Project convertToEntity(ProjectDTO projectDTO){
        return modelMapper.map(projectDTO, Project.class);
    }

    public ProjectDTO convertToEntity(Project project){
        return modelMapper.map(project , ProjectDTO.class);
    }
}
