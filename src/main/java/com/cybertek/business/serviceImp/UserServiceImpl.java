package com.cybertek.business.serviceImp;

import com.cybertek.business.dto.UserDTO;
import com.cybertek.business.entity.User;
import com.cybertek.business.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserDTO> listAllUser() {
        return null;
    }

    @Override
    public UserDTO findByUserName() {
        return null;
    }

    @Override
    public void save() {

    }

    @Override
    public UserDTO update() {
        return null;
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
