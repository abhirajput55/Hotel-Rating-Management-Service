package com.micro.userservice.external.services;

import com.micro.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/hotel/{hotelId}")
    Hotel getHotelById(@PathVariable String hotelId);
}
