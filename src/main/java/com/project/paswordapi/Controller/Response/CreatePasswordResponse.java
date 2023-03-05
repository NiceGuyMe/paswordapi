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
public class CreatePasswordResponse {
    private Long id;
    private Long userID;
    private String label;
    private String password;
}
