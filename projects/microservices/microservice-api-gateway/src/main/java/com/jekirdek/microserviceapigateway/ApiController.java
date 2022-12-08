package com.jekirdek.microserviceapigateway;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class ApiController {
    String PostServiceUrl = "http://localhost:8081";
    String AuthenticationServiceUrl = "http://localhost:8082";

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/posts")
    Object allPosts() {
        return restTemplate.getForObject(PostServiceUrl + "/posts",String.class);
    }

    @GetMapping("/post")
    Object singlePost(@RequestParam String id) {
        return restTemplate.getForObject(PostServiceUrl + "/post?id=" + id, String.class);
    }

    @PostMapping("/post")
    String newPost(@RequestBody Object body, @RequestHeader String sessionId, @RequestHeader String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("sessionId", sessionId);
        headers.set("id", id);

        HttpEntity<Object> request = new HttpEntity<>(body, headers);

        return restTemplate.postForObject(PostServiceUrl + "/post", request, String.class);
    }

    @GetMapping("/users")
    ResponseEntity<String> getAllUsers(@RequestHeader String sessionId, @RequestHeader String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("sessionId", sessionId);
        headers.set("id", id);
        HttpEntity<Object> request = new HttpEntity<>(headers);

        ResponseEntity<String> newObj = restTemplate.exchange(AuthenticationServiceUrl + "/users", HttpMethod.GET, request, String.class);

        return newObj;
    }
    @PostMapping("/login")
    String login(@RequestBody Object body) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> request = new HttpEntity<>(body, headers);

        String newObj = restTemplate.postForObject(AuthenticationServiceUrl + "/login", request, String.class);

        return newObj;
    }

    @PostMapping("/register")
    String register(@RequestBody Object body) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> request = new HttpEntity<>(body, headers);

        return restTemplate.postForObject(AuthenticationServiceUrl + "/register", body, String.class);
    }
}
