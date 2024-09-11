package com.Food.ordering.online.food.ordering.system.model;

// Importing necessary JPA annotations
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Marks this class as a JPA entity, meaning it maps to a database table
public class User {

    @Id // Specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indicates that the ID should be generated automatically by the database using an auto-increment strategy
    private Long id; // Unique identifier for each user, corresponding to the primary key in the database

    private String username; // Stores the username of the user
    private String password; // Stores the encrypted password of the user
    private String email; // Stores the email address of the user

    // Getters and Setters
    // Getter for the user's ID
    public Long getId() {
        return id;
    }

    // Setter for the user's ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the username
    public String getUsername() {
        return username;
    }

    // Setter for the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for the password
    public String getPassword() {
        return password;
    }

    // Setter for the password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for the email
    public String getEmail() {
        return email;
    }

    // Setter for the email
    public void setEmail(String email) {
        this.email = email;
    }
}
