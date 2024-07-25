package com.cloud_dp.users_pictures_microservice;

import com.cloud_dp.users_pictures_microservice.feignClient.PictureClient;
import com.cloud_dp.users_pictures_microservice.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
	private PictureClient pictureClient;

	@GetMapping("/user-pictures/{userId}")
	public List<Picture> getUserPictures(@PathVariable String userId) {
		return pictureClient.getUserPictures(userId);
	}
}
