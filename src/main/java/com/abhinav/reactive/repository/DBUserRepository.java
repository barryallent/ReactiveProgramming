package com.abhinav.reactive.repository;

import com.abhinav.reactive.dao.DBUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DBUserRepository extends ReactiveCrudRepository<DBUser, Long> {
    Flux<DBUser> findByName(String name); // Find users reactively by name
}

