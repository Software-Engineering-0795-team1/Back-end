package com.example.linkit.Controller;

import com.example.linkit.Model.User;
import com.example.linkit.Model.Project;
import com.example.linkit.Model.UserBuilder;
import com.example.linkit.Model.JobPosting;
import com.example.linkit.Model.Portfolio;
import com.example.linkit.Service.UserFacade;
import com.example.linkit.Service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserFacade userFacade;
    private final RecruiterService recruiterService;

    @Autowired
    public UserController(UserFacade userFacade, RecruiterService recruiterService) {
        this.userFacade = userFacade;
        this.recruiterService = recruiterService;
    }

    public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String role) {

        return null;
    }

    @PostMapping("/{userId}/applyProject/{projectId}")
    public ResponseEntity<String> applyToProject(@PathVariable String userId, @PathVariable String projectId) {

        return null;
    }

    @GetMapping("/{userId}/projects")
    public ResponseEntity<List<Project>> viewProjects(@PathVariable String userId) {

        return null;
    }

    @PostMapping("/{userId}/sendMessage/{recipientId}")
    public ResponseEntity<String> sendMessage(@PathVariable String userId, @PathVariable String recipientId, @RequestParam String message) {

        return null;
    }

    @GetMapping("/{userId}/jobPostings")
    public ResponseEntity<List<JobPosting>> viewJobPostings(@PathVariable String userId) {

        return null;
    }

    @PostMapping("/{userId}/uploadPortfolio")
    public ResponseEntity<String> uploadPortfolio(@PathVariable String userId, @RequestParam("file") MultipartFile file) {
        return null;
    }

    @GetMapping("/{recruiterId}/viewProfile/{userId}")
    public ResponseEntity<User> viewUserProfile(@PathVariable String recruiterId, @PathVariable String userId) {
        return null;
    }

    @GetMapping("/{recruiterId}/viewPortfolio/{userId}")
    public ResponseEntity<Portfolio> viewUserPortfolio(@PathVariable String recruiterId, @PathVariable String userId) {
        return null;
    }
}
