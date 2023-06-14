package com.micro.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    private String hotelId;

    private String hotelName;

    private String hotelAddress;

    private String hotelAbout;
}
