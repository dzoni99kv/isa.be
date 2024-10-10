package com.example.TaskApp.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseModel {
    private String token;
}
