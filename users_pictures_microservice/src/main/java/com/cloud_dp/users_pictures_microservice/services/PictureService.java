package com.cloud_dp.users_pictures_microservice.services;

import com.cloud_dp.users_pictures_microservice.exceptions.CustomPicturesException;
import com.cloud_dp.users_pictures_microservice.feignClient.PictureClient;

import com.cloud_dp.users_pictures_microservice.entities.Picture;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class PictureService {

    @Autowired
    private PictureClient pictureClient;

    private static final Logger log = LoggerFactory.getLogger(PictureService.class);

//    @Retry(name = "picturesRetry")
    @CircuitBreaker(name = "picturesCircuitBreaker", fallbackMethod = "serviceFallbackMethod")
    public List<Picture> getUserPictures(String userId) {
        log.info("Attempt to retrieve pictures for user {}", userId);
        return pictureClient.getUserPictures(userId);
    }

    public List<Picture> serviceFallbackMethod(String userId, Throwable exception) {
        log.error("Data server is either unavailable or malfunctioned due to {}", exception.getMessage());

        // Throw a custom runtime exception to trigger retry without halting the application
        throw new RuntimeException("Retrying due to: " + exception.getMessage());
    }

}
