package com.example.userservice.services;

import com.example.userservice.models.Token;
import com.example.userservice.models.User;

public interface IUserService {
    User signupUser(String email, String name, String password, Integer phoneNumber);

    Token loginUser(String email, String password);

    User validateToken(String token);
}
