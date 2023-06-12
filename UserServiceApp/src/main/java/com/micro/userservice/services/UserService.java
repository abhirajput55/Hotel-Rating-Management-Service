package com.micro.userservice.services;

import com.micro.userservice.entities.User;
import com.micro.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(Integer id);

    String deleteUserById(Integer id);

    User updateUserById(Integer id);
}
