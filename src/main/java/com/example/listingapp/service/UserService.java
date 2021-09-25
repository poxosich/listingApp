package com.example.listingapp.service;


import com.example.listingapp.model.CategoryMd;
import com.example.listingapp.model.User;
import com.example.listingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findByUserId(int id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean deleteById(int id) {
        userRepository.deleteById(id);
        return true;
    }
}
