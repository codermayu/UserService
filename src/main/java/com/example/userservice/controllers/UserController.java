package com.example.userservice.controllers;

import com.example.userservice.dtos.LoginRequestDTO;
import com.example.userservice.dtos.SignUpRequestDTO;
import com.example.userservice.dtos.UserDTO;
import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public UserDTO signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        User user = userService.signupUser(signUpRequestDTO.getEmail(), signUpRequestDTO.getName(),
                signUpRequestDTO.getPassword(), signUpRequestDTO.getPhoneNumber());
        return changeToUserDTO(user);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO){
       Token token = userService.loginUser(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
       return ResponseEntity.ok(token.getValue());

    }

    @GetMapping("/validateToken")
    public UserDTO validateToken(@RequestHeader String token) {
        return changeToUserDTO(userService.validateToken(token));
    }

    @GetMapping("/validateEurekaCall/{token}")
    public String validateEurekaCall (@PathVariable("token") String token) {
        return "Validating Eureka call via: " + token;
    }

    private UserDTO changeToUserDTO(User user){
        if (user == null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }
}
