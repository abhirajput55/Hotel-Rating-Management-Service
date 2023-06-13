package com.micro.hotelservice.services.implementation;

import com.micro.hotelservice.entities.Hotel;
import com.micro.hotelservice.exceptions.ResourceNotFoundException;
import com.micro.hotelservice.repositories.HotelRepository;
import com.micro.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

//    @Autowired
//    Hotel hotel;

    @Override
    public Hotel saveHotel(Hotel hotel) {

        String randomId = UUID.randomUUID().toString();
        hotel.setHotelId(randomId);

        Hotel newHotel = hotelRepository.save(hotel);

        return newHotel;
    }

    @Override
    public List<Hotel> getAllHotels() {

        List<Hotel> hotelList = hotelRepository.findAll();

        return hotelList;
    }

    @Override
    public Hotel getHotelById(String hotelId) {

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Ressource not found on server with the given id :: "+hotelId));

        return hotel;
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {

        Hotel newhotel = hotelRepository
                .findById(hotel.getHotelId()).orElse(null);

        if (Objects.nonNull(newhotel)){
            newhotel.setHotelName(hotel.getHotelName());
            newhotel.setHotelAddress(hotel.getHotelAddress());
            newhotel.setHotelAbout(hotel.getHotelAbout());
            hotelRepository.save(newhotel);
        }else {
            newhotel = new Hotel();

            newhotel.setHotelId(hotel.getHotelId());
            newhotel.setHotelName(hotel.getHotelName());
            newhotel.setHotelAddress(hotel.getHotelAddress());
            newhotel.setHotelAbout(hotel.getHotelAbout());
            hotelRepository.save(newhotel);
        }

        return newhotel;
    }

    @Override
    public String deleteHotel(String hotelId) {

        String status = "";
        Hotel hotel1 = hotelRepository.findById(hotelId).orElse(null);

        if (Objects.nonNull(hotel1)){
            hotelRepository.deleteById(hotelId);
            status = "Deleted...";
        }else {
            status = "Resource not found with given id :: "+hotelId;
        }

        return status;
    }
}
