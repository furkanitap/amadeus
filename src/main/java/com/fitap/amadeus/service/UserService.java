package com.fitap.amadeus.service;

import com.fitap.amadeus.model.User;

import com.fitap.amadeus.model.request.SignupRequest;
import com.fitap.amadeus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    public void createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setPassword(signupRequest.getPassword());
        user.setName(signupRequest.getName());
        user.setUsername(signupRequest.getUsername());
        userRepository.save(user);
    }
}
