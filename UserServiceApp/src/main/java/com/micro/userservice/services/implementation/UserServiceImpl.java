package com.micro.userservice.services.implementation;

import com.micro.userservice.entities.User;
import com.micro.userservice.exceptions.ResourceNotFoundExcption;
import com.micro.userservice.repositories.UserRepository;
import com.micro.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {

        //String randomId = UUID.randomUUID().toString();
        //user.setUserId(randomId);
        User newUser = userRepository.save(user);

        return newUser;
    }

    @Override
    public List<User> getAllUser() {

        List<User> userList = userRepository.findAll();

        return userList;
    }

    @Override
    public User getUserById(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExcption("User not found on server with given id !!"));

        return user;
    }

    @Override
    public String deleteUserById(Integer id) {
        return null;
    }

    @Override
    public User updateUserById(Integer id) {
        return null;
    }
}
