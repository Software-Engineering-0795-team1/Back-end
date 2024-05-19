package com.example.linkit.Controller;

import com.example.linkit.Model.Project;
import com.example.linkit.Model.JobPosting;
import com.example.linkit.Service.TagSearchStrategy;
import com.example.linkit.Service.TagSearchStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class TagSearchController {
    private final TagSearchStrategyFactory tagSearchStrategyFactory;

    @Autowired
    public TagSearchController(TagSearchStrategyFactory tagSearchStrategyFactory) {
        this.tagSearchStrategyFactory = tagSearchStrategyFactory;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> searchProjectsByTags(@RequestParam String tag) {

        return null;
    }

    @GetMapping("/jobPostings")
    public ResponseEntity<List<JobPosting>> searchJobPostingsByTags(@RequestParam List<String> tags) {

        return null;
    }
}
