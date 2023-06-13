package com.micro.hotelservice.services;

import com.micro.hotelservice.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    public Hotel saveHotel(Hotel hotel);

    public List<Hotel> getAllHotels();

    public Hotel getHotelById(String hotelId);

    public Hotel updateHotel(Hotel hotel);

    public String deleteHotel(String hotelId);
}
