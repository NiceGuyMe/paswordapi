package com.project.paswordapi.Controller.Mapper;

import com.project.paswordapi.Controller.Response.CreateUserResponse;
import com.project.paswordapi.Controller.Response.UserResponse;
import com.project.paswordapi.Entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {
    public UserResponse toRest (UserEntity userEntity){
        return UserResponse.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .build();
    }

    public UserEntity toDomain (CreateUserResponse createUserResponse){
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .username(createUserResponse.getUsername())
                .password(createUserResponse.getPassword())
                .email(createUserResponse.getEmail())
                .enabled(true)
                .build();

    }
}
