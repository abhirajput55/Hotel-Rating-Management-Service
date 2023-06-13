package com.micro.hotelservice.controllers;

import com.micro.hotelservice.entities.Hotel;
import com.micro.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/saveHotel")
    public ResponseEntity<Map<String, Object>> createNewHotel(@RequestBody Hotel hotel){
        Map<String, Object> map = new HashMap<>();

        Hotel hotel1 = hotelService.saveHotel(hotel);

        map.put("Success", true);
        map.put("Data", hotel1);

        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<Map<String, Object>> getAllHotels(){
        Map<String, Object> map = new HashMap<>();

        List<Hotel> hotelList = hotelService.getAllHotels();

        map.put("Success", true);
        map.put("Data", hotelList);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/getHotelById/{hotelId}")
    public ResponseEntity<Map<String, Object>> getAllHotelById(@PathVariable String hotelId){
        Map<String, Object> map = new HashMap<>();

        Hotel hotel = hotelService.getHotelById(hotelId);

        map.put("Success", true);
        map.put("Data", hotel);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @PutMapping("/updateHotel")
    public ResponseEntity<Map<String, Object>> updateHotel(@RequestBody Hotel hotel){
        Map<String, Object> map = new HashMap<>();

        Hotel hotel1 = hotelService.updateHotel(hotel);

        map.put("Success", true);
        map.put("Data", hotel);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
