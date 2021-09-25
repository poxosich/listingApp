package com.example.listingapp.controller;
import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.findAllUser();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        Optional<User> byId = userService.findByUserId(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/users")
    public User user(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> user(@PathVariable("id") int id, @RequestBody User user) {
        Optional<User> byId = userService.findByUserId(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User userFr = byId.get();
        userFr.setName(user.getName());
        userFr.setSurname(user.getSurname());
        userFr.setEmail(user.getEmail());
        userFr.setPassword(user.getPassword());
        userFr.setRole(user.getRole());

        return ResponseEntity.ok().body(userService.save(userFr));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
    }
}
