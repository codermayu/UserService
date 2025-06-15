package com.example.userservice.security.custom;

import com.example.userservice.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;



    public CustomUserDetails(User user) {
        // Constructor logic can be added here if needed
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.grantedAuthorities = new ArrayList<>();
        if (user.getRoles() != null) {
            for (var role : user.getRoles()) {
                this.grantedAuthorities.add(new CustomGrantedAuthority(role));
            }
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
