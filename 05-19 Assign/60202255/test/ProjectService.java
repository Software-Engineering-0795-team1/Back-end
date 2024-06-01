package com.example.linkit.Service;

import com.example.linkit.Model.Project;
import com.example.linkit.Model.User;
import com.example.linkit.Repository.ProjectRepository;
import com.example.linkit.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProjectById() {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("exampleTitle");
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Project result = projectService.getProjectById(1L);
        assertNotNull(result);
        assertEquals("exampleTitle", result.getTitle());
    }

    @Test
    void testCreateProject() {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("exampleTitle");
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        Project result = projectService.createProject(project);
        assertNotNull(result);
        assertEquals("exampleTitle", result.getTitle());
    }

    @Test
    void testUpdateProject() {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("exampleTitle");
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        Project updatedProject = new Project();
        updatedProject.setTitle("newTitle");
        Project result = projectService.updateProject(1L, updatedProject);
        assertNotNull(result);
        assertEquals("newTitle", result.getTitle());
    }

    @Test
    void testDeleteProject() {
        Project project = new Project();
        project.setId(1L);
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        projectService.deleteProject(1L);
        verify(projectRepository, times(1)).delete(project);
    }

    @Test
    void testGetAllProjects() {
        Project project1 = new Project();
        project1.setId(1L);
        project1.setTitle("exampleTitle1");

        Project project2 = new Project();
        project2.setId(2L);
        project2.setTitle("exampleTitle2");

        when(projectRepository.findAll()).thenReturn(Arrays.asList(project1, project2));

        List<Project> result = projectService.getAllProjects();
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
