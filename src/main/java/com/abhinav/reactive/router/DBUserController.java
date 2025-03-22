package com.abhinav.reactive.router;

import com.abhinav.reactive.dao.DBUser;
import com.abhinav.reactive.service.DBUserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class DBUserController {

    private final DBUserService userService;

    public DBUserController(DBUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Mono<DBUser> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public Flux<DBUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public Mono<DBUser> createUser(@RequestBody DBUser user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
