package com.riad8321.flashcash.service;

import com.riad8321.flashcash.model.User;
import com.riad8321.flashcash.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class SessionService {
    private final UserRepository userRepository;

    public SessionService(UserRepository userRepository) { this.userRepository = userRepository; }

    public User sessionUser() {
        org.springframework.security.core.userdetails.User springUser =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByEmail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email not found"));
    }
}
