package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.UserDTO;
import com.cybertek.business.entity.User;
import com.cybertek.business.mapper.MapperUtil;
import com.cybertek.business.repository.UserRepository;
import com.cybertek.business.service.UserService;
import org.springframework.data.domain.Sort;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MapperUtil mapperUtil;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> listAllUser() {

        // get from repo
//        List<User> repolist = userRepository.findAll();

//        return repolist.stream().map(each -> mapperUtil.convert(each, new UserDTO())).collect(Collectors.toList());


        List<User> list = userRepository.findAll(Sort.by("firstName"));
        return list.stream().map(obj -> {
            return mapperUtil.convert(obj,new UserDTO());
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return null;
    }

    @Override
    public void save(UserDTO userDTO) {

        User user = mapperUtil.convert(userDTO,new User());

        //encode password TODO
        //user.setPassWord(passwordEncoder.encode(user.getPassWord()));

        userRepository.save(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        // Find current user
        User userEnt = userRepository.findByUserName(userDTO.getUserName());

        userDTO.setEnables(true);
        //Map update user dto to entity objectt

        User convertedUser  = mapperUtil.convert(userDTO,new User());
        convertedUser.setPassWord(passwordEncoder.encode(convertedUser.getPassWord()));
        convertedUser.setId(userEnt.getId());


        //save updated user

        userRepository.save(convertedUser);

        return findByUserName(userDTO.getUserName());
    }

    @Override
    public void delete(String username) {

    }

    @Override
    public List<UserDTO> listAllByRole(String role) {
        return null;
    }

    @Override
    public Boolean checkIfUserCanBeDeleted(User user) {
        return null;
    }
}
