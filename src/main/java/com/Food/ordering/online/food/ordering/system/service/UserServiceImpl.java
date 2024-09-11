package com.Food.ordering.online.food.ordering.system.service;

import com.Food.ordering.online.food.ordering.system.model.User;
import com.Food.ordering.online.food.ordering.system.payload.LoginRequest;
import com.Food.ordering.online.food.ordering.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Service class for managing user-related operations.
 * Implements the UserService interface.
 */
@Service
public class UserServiceImpl implements UserService {

    // Repository for performing CRUD operations on the User entity
    @Autowired
    private UserRepository userRepository;

    // Password encoder for securely encoding user passwords
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user in the system.
     *
     * @param user The user object to be registered, containing user details.
     * @return The saved User object after registration.
     */
    @Override
    public User registerUser(User user) {
        // Encrypts the user's password before saving it to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Saves the user to the database and returns the saved User object
        return userRepository.save(user);
    }

    /**
     * Logs in a user by verifying their credentials.
     *
     * @param loginRequest An object containing the user's login credentials (username and password).
     * @return A JWT token as a string if authentication is successful, otherwise null.
     */
    @Override
    public String loginUser(LoginRequest loginRequest) {
        // Finds the user by username
        User user = userRepository.findByUsername(loginRequest.getUsername());
        // Checks if the user exists and if the provided password matches the stored password
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            // Return a JWT token if the credentials are valid (placeholder, replace with actual JWT logic)
            return "Generated-JWT-Token";
        } else {
            // Returns null if authentication fails
            return null;
        }
    }

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id The unique identifier of the user to be retrieved.
     * @return The User object if found, otherwise null.
     */
    @Override
    public User getUserById(Long id) {
        // Retrieves the user by ID from the database and returns the User object, or null if not found
        return userRepository.findById(id).orElse(null);
    }
}
