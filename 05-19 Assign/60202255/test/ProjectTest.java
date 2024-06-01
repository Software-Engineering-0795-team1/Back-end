package com.example.linkit.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void testGettersAndSetters() {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("Test Project");
        project.setDescription("Test Description");
        project.setTag("Test Tag");
        project.setStatus("Open");

        assertEquals(1L, project.getId());
        assertEquals("Test Project", project.getTitle());
        assertEquals("Test Description", project.getDescription());
        assertEquals("Test Tag", project.getTag());
        assertEquals("Open", project.getStatus());
    }

    @Test
    void testToString() {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("Test Project");

        String expected = "Project{id=1, tag='null', title='Test Project', description='null', status='null', pm=null, designers=null, developers=null}";
        assertEquals(expected, project.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Project project1 = new Project();
        project1.setId(1L);
        project1.setTitle("Test Project");

        Project project2 = new Project();
        project2.setId(1L);
        project2.setTitle("Test Project");

        assertEquals(project1, project2);
        assertEquals(project1.hashCode(), project2.hashCode());

        project2.setId(2L);
        assertNotEquals(project1, project2);
    }

    @Test
    void testConstructor() {
        Project project = new Project();
        project.setId(1L);
        project.setTag("Test Tag");
        project.setTitle("Test Project");
        project.setDescription("Test Description");
        project.setStatus("Open");

        assertEquals(1L, project.getId());
        assertEquals("Test Tag", project.getTag());
        assertEquals("Test Project", project.getTitle());
        assertEquals("Test Description", project.getDescription());
        assertEquals("Open", project.getStatus());
    }

    @Test
    void testAddDeveloper() {
        Project project = new Project();
        User user = new User();
        user.setId("1");

        List<User> developers = new ArrayList<>();
        project.setDevelopers(developers);

        project.getDevelopers().add(user);
        assertTrue(project.getDevelopers().contains(user));
    }
}
