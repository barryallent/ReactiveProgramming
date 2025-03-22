package com.abhinav.reactive.service;

import com.abhinav.reactive.dao.DBUser;
import com.abhinav.reactive.repository.DBUserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DBUserService {

    private final DBUserRepository userRepository;

    public DBUserService(DBUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<DBUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Flux<DBUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<DBUser> createUser(DBUser user) {
        return userRepository.save(user);
    }

    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }
}
