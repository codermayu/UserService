package com.example.userservice.services;

import com.example.userservice.exceptions.InvalidPasswordException;
import com.example.userservice.exceptions.UserAlreadySignedUpException;
import com.example.userservice.exceptions.UserNotPresentException;
import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.repositories.TokenRepository;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public User signupUser(String email, String name, String password, Integer phoneNumber) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            throw new UserAlreadySignedUpException("User already exists");
        }
        User userEntity = new User();
        userEntity.setEmail(email);
        userEntity.setName(name);
        userEntity.setPassword(bCryptPasswordEncoder.encode(password));
        userEntity.setPhoneNumber(phoneNumber);
        userRepository.save(userEntity);
        return userEntity;

    }

    @Override
    public Token loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

        if (!user.isPresent()) {
            throw new UserNotPresentException("User hasn't signed up yet");
        }

        if (!bCryptPasswordEncoder.matches(password, user.get().getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        Token token = new Token();
        token.setUser(user.get());
        // Set a random alphanumeric value for the token
        token.setValue(UUID.randomUUID().toString());
        token.setCreatedAt(new Date());
        // Set expiry time to 30 days from now
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, 30);
        token.setExpiryTime(cal.getTime());
        return token;
    }

    @Override
    public User validateToken(String tokenValue) {
        Optional<Token> token = tokenRepository.findByValue(tokenValue);
        if (!token.isPresent()) {
            return null; // Token not found
        }
        Token tokenEntity = token.get();
        if (tokenEntity.getExpiryTime().before(new Date())) {
            return null; // Token has expired
        } else {
            return token.get().getUser(); // Token is valid and not expired
        }
    }
}
