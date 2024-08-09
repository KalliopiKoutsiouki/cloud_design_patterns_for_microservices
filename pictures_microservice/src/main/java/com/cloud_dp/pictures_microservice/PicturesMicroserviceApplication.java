package com.cloud_dp.pictures_microservice;

import com.cloud_dp.pictures_microservice.config.ServiceAuthenticationProvider;
import com.cloud_dp.pictures_microservice.exception.CustomPicturesException;
import com.cloud_dp.pictures_microservice.model.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@EnableScheduling
public class PicturesMicroserviceApplication {

	private static final Logger log = LoggerFactory.getLogger(PicturesMicroserviceApplication.class);
	@Autowired
	ServiceAuthenticationProvider serviceAuthenticationProvider;

	public static void main(String[] args) {
		SpringApplication.run(PicturesMicroserviceApplication.class, args);
	}

	@GetMapping("/pictures/{userId}")
	public List<Picture> getUserPictures(@PathVariable String userId, @RequestHeader("Authorization") String token) throws CustomPicturesException {

		if (userId.equals("1")) {
			return Arrays.asList(
					new Picture("1", userId, "http://example.com/pic1.jpg"),
					new Picture("2", userId, "http://example.com/pic2.jpg")
			);
		} else {
			throw new CustomPicturesException("Error");
		}
	}
}

