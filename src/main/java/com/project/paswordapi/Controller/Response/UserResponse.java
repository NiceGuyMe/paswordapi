package com.project.paswordapi.Controller.Response;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class UserResponse {
    private UUID id;
    private String username;

}
