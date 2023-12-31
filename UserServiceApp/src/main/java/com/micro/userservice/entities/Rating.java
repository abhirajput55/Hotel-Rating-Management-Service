package com.micro.userservice.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private Integer ratingId;
    private Integer userId;
    private String hotelId;
    private Integer rating;
    private String feedback;
    private Hotel hotel;

}
