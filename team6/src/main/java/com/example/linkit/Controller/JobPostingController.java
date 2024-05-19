package com.example.linkit.Controller;
import com.example.linkit.Model.JobPosting;
import com.example.linkit.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobPosting")
public class JobPostingController {
    private final JobService jobService;

    @Autowired
    public JobPostingController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/{jobPostingId}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable String jobPostingId) {

        return null;
    }

    @PostMapping
    public ResponseEntity<String> createJobPosting(@RequestBody JobPosting jobPosting) {

        return null;
    }

    @PutMapping("/{jobPostingId}")
    public ResponseEntity<String> updateJobPosting(@PathVariable String jobPostingId, @RequestBody JobPosting jobPosting) {

        return null;
    }

    @DeleteMapping("/{jobPostingId}")
    public ResponseEntity<String> deleteJobPosting(@PathVariable String jobPostingId) {

        return null;
    }

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {

        return null;
    }
}
