package com.Food.ordering.online.food.ordering.system.controller;

// Importing necessary classes and annotations
import com.Food.ordering.online.food.ordering.system.model.User;
import com.Food.ordering.online.food.ordering.system.payload.JwtResponse;
import com.Food.ordering.online.food.ordering.system.payload.LoginRequest;
import com.Food.ordering.online.food.ordering.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Marks this class as a REST controller, allowing it to handle HTTP requests
@RequestMapping(value = "api/v1") // Base URL for all endpoints in this controller is /api/v1
public class UserController {

    @Autowired // Injects an instance of UserService into this controller
    private UserService userService;

    /**
     * Endpoint to register a new user.
     * URL: /api/v1/register
     * Method: POST
     * Input: A User object as JSON in the request body
     * Output: The created User object and HTTP status 201 (Created)
     */
    @PostMapping(value = "/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.registerUser(user); // Registers the user using the service layer
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // Returns the created user and a 201 status
    }

    /**
     * Endpoint to log in a user.
     * URL: /api/v1/login
     * Method: POST
     * Input: A LoginRequest object containing username and password
     * Output: A JwtResponse containing the JWT token if successful, or 401 (Unauthorized) if not
     */
    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        String token = userService.loginUser(loginRequest); // Authenticates the user and generates a JWT token
        if (token != null) {
            return ResponseEntity.ok(new JwtResponse(token)); // Returns the token if authentication is successful
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Returns a 401 status if authentication fails
    }

    /**
     * Endpoint to retrieve a user's profile based on user ID.
     * URL: /api/v1 (POST)
     * Method: POST
     * Input: User ID as Long in the request body
     * Output: The User object corresponding to the provided ID and HTTP status 200 (OK)
     */
    @PostMapping(value = "")
    public ResponseEntity<User> userProfile(@RequestBody Long id) {
        User user = userService.getUserById(id); // Retrieves the user by ID using the service layer
        return ResponseEntity.ok(user); // Returns the user and a 200 status
    }

    /**
     * Endpoint to retrieve a user's profile based on user ID passed as a path variable.
     * URL: /api/v1/{id}
     * Method: GET
     * Input: User ID as Long in the URL path
     * Output: The User object corresponding to the provided ID and HTTP status 200 (OK)
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long id) {
        User user = userService.getUserById(id); // Retrieves the user by ID using the service layer
        return ResponseEntity.ok(user); // Returns the user and a 200 status
    }
}
