package com.cloud_dp.users_pictures_microservice;

import com.cloud_dp.users_pictures_microservice.entities.Picture;
import com.cloud_dp.users_pictures_microservice.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableFeignClients
public class UsersPicturesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersPicturesMicroserviceApplication.class, args);
	}

	@Autowired
	private PictureService pictureService;

	@GetMapping("/user-pictures/{userId}")
	@PreAuthorize("isAuthenticated()")
	public List<Picture> getUserPictures(@PathVariable String userId) {
//		throw new RuntimeException("Not implemented");
		return pictureService.getUserPictures(userId);
	}
}
