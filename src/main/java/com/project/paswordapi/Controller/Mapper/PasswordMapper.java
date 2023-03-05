package com.project.paswordapi.Controller.Mapper;

import com.project.paswordapi.Controller.Response.PasswordResponse;
import com.project.paswordapi.Entity.PasswordEntity;
import com.project.paswordapi.Entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PasswordMapper {
    public PasswordResponse toRest (PasswordEntity domain){
        return PasswordResponse.builder()
                .label(domain.getLabel())
                .password(domain.getPassword())
                .UserId(domain.getUserEntity().getId())
                .build();
    }

    public PasswordEntity toDomain(PasswordResponse rest){
        UserEntity user = new UserEntity();
        user.setId(rest.getUserId());
        return PasswordEntity.builder()
                .id(UUID.randomUUID())
                .label(rest.getLabel())
                .password(rest.getPassword())
                .userEntity(user)
                .build();
    }
}
