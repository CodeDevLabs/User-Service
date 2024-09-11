package com.Food.ordering.online.food.ordering.system.payload;

import lombok.Getter;

@Getter
public class JwtResponse {
    // Getter
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

}
