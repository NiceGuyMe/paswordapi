package com.project.paswordapi.Controller.Response;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class CreatePasswordResponses {
    private UUID UserId;
    private String label;
    private String password;
}
