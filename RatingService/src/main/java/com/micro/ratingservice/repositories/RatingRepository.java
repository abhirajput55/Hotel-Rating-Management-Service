package com.micro.ratingservice.repositories;

import com.micro.ratingservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    List<Rating> findRatingByUserId(Integer userId);

    List<Rating> findRatingByHotelId(String hotelId);


}
