package com.example.userservice.security.custom;

import com.example.userservice.models.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private String authority;

    public CustomGrantedAuthority(Role role) {
        this.authority = role.getName();
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
