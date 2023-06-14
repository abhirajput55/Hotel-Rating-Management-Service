package com.micro.userservice.controllers;

import com.micro.userservice.entities.Rating;
import com.micro.userservice.entities.User;
import com.micro.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/saveUser")
    public ResponseEntity<Map<String, Object>> createNewUser(@RequestBody User user){

        Map<String, Object> map = new HashMap<>();

        User createdUser = userService.saveUser(user);

        map.put("Success", true);
        map.put("Data", createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<Map<String, Object>> getListOfAllUsers(){
        Map<String, Object> map = new HashMap<>();

        List<User> userList = userService.getAllUser();

        map.put("Success", true);
        map.put("Data", userList);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<Map<String, Object>> getUserByUserId(@PathVariable Integer userId){
        Map<String, Object> map = new HashMap<>();

        User user = userService.getUserById(userId);

        HashMap<String, Object> hashMap = restTemplate
                .getForObject("http://localhost:8083/ratings/users/" +
                        user.getUserId(), HashMap.class);

        ArrayList<Rating> ratingList = (ArrayList<Rating>) hashMap.get("Data");

        user.setRatings(ratingList);

        map.put("Success", true);
        map.put("Data", user);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
