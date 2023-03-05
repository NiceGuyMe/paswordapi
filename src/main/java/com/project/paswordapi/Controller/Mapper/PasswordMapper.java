package com.project.paswordapi.Controller.Mapper;

import com.project.paswordapi.Controller.Response.CreatePasswordResponse;
import com.project.paswordapi.Controller.Response.PasswordResponse;
import com.project.paswordapi.Entity.PasswordEntity;
import com.project.paswordapi.Entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class PasswordMapper {
    public PasswordResponse toRest (PasswordEntity domain){
        return PasswordResponse.builder()
                .id(domain.getId())
                .label(domain.getLabel())
                .password(domain.getPassword())
                .UserID(domain.getUserEntity().getId())
                .build();
    }

    public PasswordEntity toDomain(CreatePasswordResponse rest){
        UserEntity user = new UserEntity();
        user.setId(rest.getUserID());
        return PasswordEntity.builder()
                .id(rest.getId())
                .label(rest.getLabel())
                .password(rest.getPassword())
                .userEntity(user)
                .build();
    }
}
