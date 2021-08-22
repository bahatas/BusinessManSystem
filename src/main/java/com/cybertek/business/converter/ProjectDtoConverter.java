package com.cybertek.business.converter;

import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {

    @Autowired @Lazy
    ProjectService projectService;


    @Override
    public ProjectDTO convert(String source) {
        return projectService.getByProjectCode(source);
    }
}
