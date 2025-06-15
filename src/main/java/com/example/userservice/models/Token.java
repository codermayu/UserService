package com.example.userservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Token extends BaseModel{

    private String value;

    private Date expiryTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
