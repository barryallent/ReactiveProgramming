package com.abhinav.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
		Flux<String> dataStream = Flux.just("Hello", "Reactive", "World");

		dataStream
				.map(String::toUpperCase) // Transform data
				.subscribe(System.out::println); // Subscribe and consume
	}

}
