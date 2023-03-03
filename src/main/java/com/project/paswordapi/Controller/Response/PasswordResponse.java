package com.project.paswordapi.Controller.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class PasswordResponse {
    private Long id;
    private Long UserID;

    private String label;
    private String password;
}
