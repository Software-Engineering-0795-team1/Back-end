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
        User user = new UserBuilder()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .setRole(role)
                .build();
        // User를 데이터베이스에 저장하는 로직 추가
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/applyProject/{projectId}")
    public ResponseEntity<String> applyToProject(@PathVariable String userId, @PathVariable String projectId) {
        userFacade.applyToProject(userId, projectId);
        return ResponseEntity.ok("Applied to project successfully");
    }

    @GetMapping("/{userId}/projects")
    public ResponseEntity<List<Project>> viewProjects(@PathVariable String userId) {
        List<Project> projects = userFacade.viewProjects(userId);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/{userId}/sendMessage/{recipientId}")
    public ResponseEntity<String> sendMessage(@PathVariable String userId, @PathVariable String recipientId, @RequestParam String message) {
        userFacade.sendMessage(userId, recipientId, message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/{userId}/jobPostings")
    public ResponseEntity<List<JobPosting>> viewJobPostings(@PathVariable String userId) {
        List<JobPosting> jobPostings = userFacade.viewJobPostings(userId);
        return ResponseEntity.ok(jobPostings);
    }

    @PostMapping("/{userId}/uploadPortfolio")
    public ResponseEntity<String> uploadPortfolio(@PathVariable String userId, @RequestParam("file") MultipartFile file) {
        try {
            String filePath = file.getOriginalFilename();
            userFacade.uploadPortfolio(userId, filePath);
            return ResponseEntity.ok("Portfolio uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload portfolio");
        }
    }

    @GetMapping("/{recruiterId}/viewProfile/{userId}")
    public ResponseEntity<User> viewUserProfile(@PathVariable String recruiterId, @PathVariable String userId) {
        User user = recruiterService.viewUserProfile(recruiterId, userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(403).body(null); // 열람 권한이 없음을 표시
    }

    @GetMapping("/{recruiterId}/viewPortfolio/{userId}")
    public ResponseEntity<Portfolio> viewUserPortfolio(@PathVariable String recruiterId, @PathVariable String userId) {
        Portfolio portfolio = recruiterService.viewUserPortfolio(recruiterId, userId);
        if (portfolio != null) {
            return ResponseEntity.ok(portfolio);
        }
        return ResponseEntity.status(403).body(null); // 열람 권한이 없음을 표시
    }
}
