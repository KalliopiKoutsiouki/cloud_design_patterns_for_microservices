package com.cloud_dp.users_pictures_microservice.mappers;

import com.cloud_dp.users_pictures_microservice.dtos.SignUpDto;
import com.cloud_dp.users_pictures_microservice.dtos.UserDto;
import com.cloud_dp.users_pictures_microservice.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
