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

import java.util.*;

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

	@GetMapping("/pictures/{username}")
	public List<Picture> getUserPictures(@PathVariable String username, @RequestHeader("Authorization") String token) throws CustomPicturesException {
		if (username.equals("tost")) {
			Picture item1 = new Picture("https://www.independenttradingco.com/cdn/shop/products/IND5000P-ALPG_2048x.jpg?v=1718147049", "Hoodie: 25$");
			Picture item2 = new Picture("https://i5.walmartimages.com/asr/9cc0dbcf-d758-4836-b704-3dcbf7c6e357.432a95a8f9e32bb860f334c91b9445df.jpeg", "Cargo Pants: 30$");
			Picture item3 = new Picture("https://cdn.mos.cms.futurecdn.net/N983zy9VUutHiZV8RBbmaA.jpg", "Pink Heels: 20$");
			return List.of(item1, item2, item3);
		} else {
			throw new CustomPicturesException("Error");
		}
	}

}

