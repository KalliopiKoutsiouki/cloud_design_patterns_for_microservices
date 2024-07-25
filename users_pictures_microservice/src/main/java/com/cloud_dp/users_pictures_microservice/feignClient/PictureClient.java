package com.cloud_dp.users_pictures_microservice.feignClient;

import com.cloud_dp.users_pictures_microservice.model.Picture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "pictures-microservice")
public interface PictureClient {

    @GetMapping("/pictures/{userId}")
    List<Picture> getUserPictures(@PathVariable String userId);
}
