package com.example.linkit.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setId("1");
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setRole("ROLE_USER");

        assertEquals("1", user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    void testConstructor() {
        User user = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");

        assertEquals("1", user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    void testToString() {
        User user = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");

        String expected = "User{id='1', name='John Doe', email='john.doe@example.com', password='password123', role='ROLE_USER'}";
        assertEquals(expected, user.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        User user1 = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");
        User user2 = new User("1", "John Doe", "john.doe@example.com", "password123", "ROLE_USER");

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());

        user2.setId("2");
        assertNotEquals(user1, user2);
    }

    @Test
    void testSetters() {
        User user = new User();
        user.setId("1");
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setRole("ROLE_USER");

        assertEquals("1", user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("ROLE_USER", user.getRole());
    }
}
