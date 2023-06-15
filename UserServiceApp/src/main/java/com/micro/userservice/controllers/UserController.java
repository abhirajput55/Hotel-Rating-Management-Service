package com.micro.userservice.controllers;

import com.micro.userservice.entities.Hotel;
import com.micro.userservice.entities.Rating;
import com.micro.userservice.entities.User;
import com.micro.userservice.external.services.HotelService;
import com.micro.userservice.external.services.RatingService;
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
    HotelService hotelService;
    @Autowired
    RatingService ratingService;
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

//      Calling another service by using RestTeplate
//        Rating[] ratingArray = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" +
//                user.getUserId(), Rating[].class);

        //By using Fegin Client
        Rating[] ratingArray = ratingService.getRatingsOfUser(userId);

        List<Rating> ratingList = Arrays.stream(ratingArray).collect(Collectors.toList());

        List<Rating> ratings = ratingList.stream().map(rating -> {
//      Calling another service by using RestTeplate
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/getHotelById/" +
//                    rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();

            //By using Fegin Client
            Hotel hotel = hotelService.getHotelById(rating.getHotelId());

            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratings);

        map.put("Success", true);
        map.put("Data", user);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
