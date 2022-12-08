package com.jekirdek.microservicespost;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PostController {
    private final PostRepository repository;
    String AuthenticationServiceUrl = "http://localhost:8082";

    private final RestTemplate restTemplate = new RestTemplate();

    PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/posts")
    List<Post> all() {
        return repository.findAll();
    }

    @GetMapping("/post")
    Post singlePost(@RequestParam Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/post")
    Post newPost(@RequestBody Post newPost, @RequestHeader String sessionId) {
        AuthObject authObject = new AuthObject(sessionId, newPost.getUserId());

        Boolean isLoggedIn = restTemplate.postForObject(AuthenticationServiceUrl + "/auth", authObject, Boolean.class);

        if(isLoggedIn) {
            return repository.save(newPost);
        } else {
            return null;
        }
    }
}
