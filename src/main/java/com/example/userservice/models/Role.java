package com.example.userservice.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Role extends BaseModel{

   private String name;

}
