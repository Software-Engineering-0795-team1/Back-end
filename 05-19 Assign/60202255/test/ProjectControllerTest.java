package com.example.linkit.Controller;

import com.example.linkit.Model.Project;
import com.example.linkit.Service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllProjects() throws Exception {
        Project project1 = new Project();
        project1.setId(1L);
        project1.setTitle("Project 1");

        Project project2 = new Project();
        project2.setId(2L);
        project2.setTitle("Project 2");

        List<Project> projects = Arrays.asList(project1, project2);

        given(projectService.getAllProjects()).willReturn(projects);

        mockMvc.perform(get("/project"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Project 1"))
                .andExpect(jsonPath("$[1].title").value("Project 2"));
    }

    @Test
    void testGetProjectById() throws Exception {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("Project 1");

        given(projectService.getProjectById(1L)).willReturn(project);

        mockMvc.perform(get("/project/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Project 1"));
    }

    @Test
    void testCreateProject() throws Exception {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("Project 1");

        given(projectService.createProject(any(Project.class))).willReturn(project);

        mockMvc.perform(post("/project")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Project 1"));
    }

    @Test
    void testUpdateProject() throws Exception {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("Updated Project");

        given(projectService.updateProject(anyLong(), any(Project.class))).willReturn(project);

        mockMvc.perform(put("/project/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Project"));
    }

    @Test
    void testDeleteProject() throws Exception {
        willDoNothing().given(projectService).deleteProject(1L);

        mockMvc.perform(delete("/project/1"))
                .andExpect(status().isOk());
    }
}
