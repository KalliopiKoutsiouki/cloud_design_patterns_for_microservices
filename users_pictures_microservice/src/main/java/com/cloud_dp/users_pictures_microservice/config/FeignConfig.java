package com.cloud_dp.users_pictures_microservice.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor(TokenProvider tokenProvider) {
        return requestTemplate -> {
            String token = tokenProvider.createPicturesToken();
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
}