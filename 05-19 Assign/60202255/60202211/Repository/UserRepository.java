package com.example.linkit.Repository;


import com.example.linkit.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByNameContaining(String name);
    List<User> findByEmailContaining(String email);
}
