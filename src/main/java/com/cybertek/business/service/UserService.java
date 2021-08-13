package com.cybertek.business.service;

import com.cybertek.business.dto.UserDTO;
import com.cybertek.business.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDTO> listAllUser();

    UserDTO findByUserName(String username);

    void save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    void delete(String username);

    List<UserDTO> listAllByRole(String role);

    Boolean checkIfUserCanBeDeleted(User user);


}
