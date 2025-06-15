package com.example.userservice.dtos;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String email;
    private String password;
}
