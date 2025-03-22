package com.abhinav.reactive.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
//Table not automatically created like in JPA, so we need to create it manually
@Table("db_users") // Table name in DB
public class DBUser {

    @Id
    private Long id;
    private String name;
    private String email;

    public DBUser(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
}

