package com.Food.ordering.online.food.ordering.system.repository;

import com.Food.ordering.online.food.ordering.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
