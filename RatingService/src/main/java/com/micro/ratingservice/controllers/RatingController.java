package com.micro.ratingservice.controllers;

import com.micro.ratingservice.entities.Rating;
import com.micro.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/rating")
    public ResponseEntity<Map<String, Object>> createNewRating(@RequestBody Rating rating){

        Map<String, Object> map = new HashMap<>();

        Rating rating1 = ratingService.saveRating(rating);

        map.put("Success", true);
        map.put("Data", rating1);

        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }

    @GetMapping("/rating")
    public ResponseEntity<Map<String, Object>> getAllRating(){

        Map<String, Object> map = new HashMap<>();

        List<Rating> ratingList = ratingService.getAllRatings();

        map.put("Success", true);
        map.put("Data", ratingList);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/rating/{ratingId}")
    public ResponseEntity<Map<String, Object>> getRatingById(@PathVariable Integer ratingId){

        Map<String, Object> map = new HashMap<>();

        Rating rating = ratingService.getRatingById(ratingId);

        map.put("Success", true);
        map.put("Data", rating);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/ratingByUser/{userId}")
    public ResponseEntity<Map<String, Object>> getRatingByUserId(@PathVariable Integer userId){

        Map<String, Object> map = new HashMap<>();

        List<Rating> ratingList = ratingService.getRatingByUser(userId);

        map.put("Success", true);
        map.put("Data", ratingList);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/ratingByHotel/{hotelId}")
    public ResponseEntity<Map<String, Object>> getRatingByHotelId(@PathVariable String hotelId){

        Map<String, Object> map = new HashMap<>();

        List<Rating> ratingList = ratingService.getRatingByHotel(hotelId);

        map.put("Success", true);
        map.put("Data", ratingList);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
