package com.cloud_dp.users_pictures_microservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    @Size(max = 100)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    @Size(max = 100)
    private String lastName;

    @Column(name = "USER_NAME", nullable = false)
    @Size(max = 100)
    private String username;

    @Column(name ="PASSWORD", nullable = false)
    @Size(max = 100)
    private String password;
}
