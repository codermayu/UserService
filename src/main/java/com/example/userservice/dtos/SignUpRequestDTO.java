package com.example.userservice.dtos;

import lombok.Data;

@Data
public class SignUpRequestDTO {

    String name;
    String email;
    String password;
    Integer phoneNumber;

}
