package com.micro.userservice.external.services;

import com.micro.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    Rating[] getRatingsOfUser(@PathVariable Integer userId);

    @PostMapping("/ratings/rating")
    public Map<String, Object> createRating(Rating rating);

    @PutMapping("ratings/rating")
    public Rating updateRating(Rating rating);
}
