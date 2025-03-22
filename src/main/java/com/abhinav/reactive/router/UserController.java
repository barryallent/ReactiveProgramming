package com.abhinav.reactive.router;

import com.abhinav.reactive.dto.User;
import com.abhinav.reactive.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint returning all users at once (Mono<List<User>>)
    @GetMapping("/users-mono")
    public Mono<List<User>> getUsersAsMono() {
        return userService.getAllUsersAsMono();
    }

    // Endpoint streaming users one by one (Flux<User>)
    @GetMapping("/users-flux")
    public Flux<User> getUsersAsFlux() {
        return userService.getAllUsersAsFlux();
    }
}

