package com.abhinav.reactive;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import reactor.core.publisher.Mono;

public class R2dbcTest {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = ConnectionFactories.get(
                "r2dbc:postgresql://admin:admin@localhost:5434/reactive-local"
        );
        Mono.from(connectionFactory.create())
                .doOnSuccess(conn -> System.out.println("✅ Connected successfully!"))
                .doOnError(err -> System.out.println("❌ Connection failed: " + err.getMessage()))
                .subscribe();
    }
}
