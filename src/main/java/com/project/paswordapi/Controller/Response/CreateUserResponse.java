package com.project.paswordapi.Controller.Response;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class CreateUserResponse {
    private String username;
    private String password;
    private String email;
}
