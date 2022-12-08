package com.jekirdek.microservicesauthentication;

import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    private final UserRepository repository;
    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all(@RequestHeader String sessionId, @RequestHeader String id) {
        User userToCompare = repository.findById(Long.parseLong(id)).orElseThrow();

        if(sessionId.equals(userToCompare.getSessionId())) {
            return repository.findAll();
        }
        return null;
    }

    @PostMapping("/register")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PostMapping("/login")
    String loginUser(@RequestBody User user) {
        User userToCompare = repository.findById(user.getId()).orElseThrow();

        if(userToCompare.getPassword().equals(user.getPassword()) && userToCompare.getUsername().equals(user.getUsername())) {
            byte[] array = new byte[16];
            String sessionId = String.valueOf(System.currentTimeMillis()).substring(8, 13) + UUID.randomUUID().toString().substring(1,10);

            userToCompare.setSessionId(sessionId);
            repository.save(userToCompare);

            return sessionId;
        }
        else {
            return "invalid credentials.";
        }
    }

    @PostMapping("/auth")
    Boolean authorize(@RequestBody User user) {
        User userToCompare = repository.findById(user.getId()).orElseThrow();

        if(user.getSessionId().equals(userToCompare.getSessionId())) {
            return true;
        }
        return false;
    }
}
