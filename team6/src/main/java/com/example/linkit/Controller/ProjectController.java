package com.example.linkit.Controller;

import com.example.linkit.Model.Project;
import com.example.linkit.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable String projectId) {

        return null;
    }

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody Project project) {

        return null;
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<String> updateProject(@PathVariable String projectId, @RequestBody Project project) {

        return null;
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable String projectId) {

        return null;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {

        return null;
    }
}
