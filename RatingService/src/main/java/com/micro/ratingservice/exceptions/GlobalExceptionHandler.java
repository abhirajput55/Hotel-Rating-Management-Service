package com.micro.ratingservice.exceptions;

import com.micro.ratingservice.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExcetion.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundExcetion notFoundExcption){

        String message = notFoundExcption.getMessage();

        ApiResponse apiResponse =
                ApiResponse.builder().message(message)
                        .success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }
}

