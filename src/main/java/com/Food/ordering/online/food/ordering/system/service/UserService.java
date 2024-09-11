package com.Food.ordering.online.food.ordering.system.service;

import com.Food.ordering.online.food.ordering.system.model.User;
import com.Food.ordering.online.food.ordering.system.payload.LoginRequest;

public interface UserService {
    User registerUser(User user);
    String loginUser(LoginRequest loginRequest);
    User getUserById(Long id);
}
