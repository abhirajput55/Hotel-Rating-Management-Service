package com.micro.ratingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "micro_rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id")
    private Integer ratingId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "hotel_id")
    private String hotelId;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "feedback")
    private String feedback;
}
