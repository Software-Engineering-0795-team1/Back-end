package com.example.linkit.Service;

import com.example.linkit.Model.User;
import com.example.linkit.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById() {
        User user = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        User result = userService.getUserById("1");
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }

    @Test
    void testCreateUser() {
        User user = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.createUser(user);
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testUpdateUser() {
        User user = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");
        User updatedUser = new User("1", "Jane Doe", "jane.doe@example.com", "password123", "ROLE_USER");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User result = userService.updateUser("1", updatedUser);
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        User user = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        userService.deleteUser("1");
        verify(userRepository, times(1)).deleteById("1");
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");
        User user2 = new User("2", "Jane Doe", "jane.doe@example.com", "password123", "ROLE_USER");
        List<User> users = List.of(user1, user2);
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
