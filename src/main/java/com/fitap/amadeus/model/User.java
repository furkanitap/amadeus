package com.fitap.amadeus.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){

    }

}
