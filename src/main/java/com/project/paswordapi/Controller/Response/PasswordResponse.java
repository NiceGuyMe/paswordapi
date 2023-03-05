package com.project.paswordapi.Controller.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class PasswordResponse {
    private UUID UserId;
    private String label;
    private String password;
}
