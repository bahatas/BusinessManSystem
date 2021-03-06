package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.UserDTO;
import com.cybertek.business.entity.User;
import com.cybertek.business.mapper.MapperUtil;
import com.cybertek.business.repository.UserRepository;
import com.cybertek.business.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MapperUtil mapperUtil;
//    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
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

        User byUserName = userRepository.findByUserName(username);

        return mapperUtil.convert(byUserName,new UserDTO());

    }

    @Override
    public void save(UserDTO userDTO) {

        User user = mapperUtil.convert(userDTO,new User());

        //encode password TODO
        //user.setPassWord(passwordEncoder.encode(user.getPassWord()));

        user.setInsertUserId(1L);//todo
        user.setLastUpdateUserId(1L);//todo
        user.setLastUpdateDateTime(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        // Find current user
        User userEnt = userRepository.findByUserName(userDTO.getUserName());

        userDTO.setEnables(true);
        //Map update user dto to entity objectt

        User convertedUser  = mapperUtil.convert(userDTO,new User());
//        convertedUser.setPassWord(passwordEncoder.encode(convertedUser.getPassWord())); todo
        convertedUser.setId(userEnt.getId());
        convertedUser.setInsertUserId(1L);//todo
        convertedUser.setLastUpdateUserId(1L);//todo
        convertedUser.setLastUpdateDateTime(LocalDateTime.now());



        //save updated user

        userRepository.save(convertedUser);

        return findByUserName(userDTO.getUserName());
    }

    @Override
    public void delete(String username) {


        User byUserName = userRepository.findByUserName(username);
        byUserName.setIsDeleted(true);
        userRepository.save(byUserName);

    }

    @Override
    public List<UserDTO> listAllByRole(String role) {

        List<User> manager=userRepository.findAllByRoleDescriptionIgnoreCase(role);

//        List<User> manager = userRepository.findAll().stream().filter(each ->
//                each.getRole().getDescription().equalsIgnoreCase("manager")).collect(Collectors.toList());

        return manager.stream().map(each->mapperUtil.convert(each, new UserDTO())).collect(Collectors.toList());

    }

    @Override
    public Boolean checkIfUserCanBeDeleted(User user) {
        return null;
    }
}
