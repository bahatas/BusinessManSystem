package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.RoleDTO;
import com.cybertek.business.entity.Role;
import com.cybertek.business.mapper.MapperUtil;
import com.cybertek.business.repository.RoleRepository;
import com.cybertek.business.service.RoleService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> list  = roleRepository.findAll();


        return list.stream().map(each-> mapperUtil.convert(each, new RoleDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {
        Role role = roleRepository.findById(id).get();
        return mapperUtil.convert(role, new RoleDTO()) ;
    }
}
