package com.micro.userservice.controllers;

import com.micro.userservice.entities.Hotel;
import com.micro.userservice.entities.Rating;
import com.micro.userservice.entities.User;
import com.micro.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

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

        Rating[] ratingArray = restTemplate.getForObject("http://localhost:8083/ratings/users/" +
                user.getUserId(), Rating[].class);

        List<Rating> ratingList = Arrays.stream(ratingArray).collect(Collectors.toList());

        List<Rating> ratings = ratingList.stream().map(rating -> {

            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotels/getHotelById/" +
                    rating.getHotelId(), Hotel.class);

            Hotel hotel = forEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratings);

        map.put("Success", true);
        map.put("Data", user);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
