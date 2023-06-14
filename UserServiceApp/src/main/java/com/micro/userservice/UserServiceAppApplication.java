package com.micro.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceAppApplication.class, args);

	}

}
