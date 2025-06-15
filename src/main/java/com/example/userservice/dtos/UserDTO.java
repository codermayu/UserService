package com.example.userservice.dtos;

import com.example.userservice.models.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

   private String name;

   private String email;

   private String password;

   private Integer phoneNumber;

   private List<Role> roles;


}
