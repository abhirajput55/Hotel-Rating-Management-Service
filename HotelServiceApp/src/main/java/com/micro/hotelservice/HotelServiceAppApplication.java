package com.micro.hotelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HotelServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceAppApplication.class, args);
	}

}
