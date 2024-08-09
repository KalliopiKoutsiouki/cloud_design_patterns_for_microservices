package com.cloud_dp.users_pictures_microservice.dtos;

public record SignUpDto (String firstName, String lastName, String username, char[] password) { }
