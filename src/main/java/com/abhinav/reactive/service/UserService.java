package com.abhinav.reactive.service;

import com.abhinav.reactive.dto.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

@Service
public class UserService {
    private final List<User> users;

    public UserService() {
        // Generating 10,000 users for testing
        this.users = IntStream.rangeClosed(1, 10000)
                .mapToObj(i -> new User(String.valueOf(i), "User-" + i))
                .toList();
    }


    //It just delays entire response by 100ms, so it will return all users at once with no timeout
    public Mono<List<User>> getAllUsersAsMono() {

        //Even with 90s timeout the request will not timeout because we are using netty and reactive programming
//        try {
//            Thread.sleep(90_000); // Sleep for 90 seconds
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt(); // Restore the interrupted status
//        }
        return Mono.just(users)
                .delayElement(Duration.ofMillis(100)); // Returns all users at once
    }


    //if we were using Tomcat here then the request would timeout as it waits for all the users to be fetched and then sends the response
    //but with netty and reactive programming we can stream the users one by one

    //delays the response by 100ms for each user, so it will keep returning element after 100ms, so if we don't use
    //netty then there will be timeout because each user delayed by 100ms and we have 10,000 users, so total 1000s
    //so any normal server times out after 30s, but with netty it will keep streaming the users one by one
    public Flux<User> getAllUsersAsFlux() {
        return Flux.fromIterable(users)
                .delayElements(Duration.ofMillis(100)); // Streams users one by one
    }
}