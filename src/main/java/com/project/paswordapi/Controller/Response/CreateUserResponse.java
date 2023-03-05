package com.project.paswordapi.Controller.Response;

import lombok.*;


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
