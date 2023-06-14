package com.micro.ratingservice.services.implementation;

import com.micro.ratingservice.entities.Rating;
import com.micro.ratingservice.exceptions.ResourceNotFoundExcetion;
import com.micro.ratingservice.repositories.RatingRepository;
import com.micro.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {

        Rating rating1 = ratingRepository.save(rating);

        return rating1;
    }

    @Override
    public List<Rating> getAllRatings() {

        List<Rating> ratingList = ratingRepository.findAll();

        return ratingList;
    }

    @Override
    public Rating getRatingById(Integer id) {

        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExcetion("Resource not found with the given Id :: "+id));

        return rating;
    }

    @Override
    public List<Rating> getRatingByUser(Integer userId) {

        List<Rating> ratingList = ratingRepository.findRatingByUserId(userId);

        return ratingList;
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {

        List<Rating> ratingList = ratingRepository.findRatingByHotelId(hotelId);

        return ratingList;
    }
}
