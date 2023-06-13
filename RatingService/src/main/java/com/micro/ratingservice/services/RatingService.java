package com.micro.ratingservice.services;

import com.micro.ratingservice.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    public Rating saveRating(Rating rating);

    public List<Rating> getAllRatings();

    public Rating getRatingById(Integer id);

    public List<Rating> getRatingByUser(Integer userId);

    public List<Rating> getRatingByHotel(String hotelId);


}
