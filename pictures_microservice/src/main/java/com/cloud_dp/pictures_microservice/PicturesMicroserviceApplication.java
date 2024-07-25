package com.cloud_dp.pictures_microservice;

import com.cloud_dp.pictures_microservice.model.Picture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@EnableScheduling
public class PicturesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicturesMicroserviceApplication.class, args);
	}

	@GetMapping("/pictures/{userId}")
	public List<Picture> getUserPictures(@PathVariable String userId) {
		return Arrays.asList(
				new Picture("1", userId, "http://example.com/pic1.jpg"),
				new Picture("2", userId, "http://example.com/pic2.jpg")
		);
	}
}

