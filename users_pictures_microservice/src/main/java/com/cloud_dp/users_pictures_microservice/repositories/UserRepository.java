package com.cloud_dp.users_pictures_microservice.repositories;

import com.cloud_dp.users_pictures_microservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
