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
        JobPosting jobPosting = jobService.getJobPostingById(jobPostingId);
        return ResponseEntity.ok(jobPosting);
    }

    @PostMapping
    public ResponseEntity<String> createJobPosting(@RequestBody JobPosting jobPosting) {
        jobService.createJobPosting(jobPosting);
        return ResponseEntity.ok("Job posting created successfully");
    }

    @PutMapping("/{jobPostingId}")
    public ResponseEntity<String> updateJobPosting(@PathVariable String jobPostingId, @RequestBody JobPosting jobPosting) {
        jobService.updateJobPosting(jobPostingId, jobPosting);
        return ResponseEntity.ok("Job posting updated successfully");
    }

    @DeleteMapping("/{jobPostingId}")
    public ResponseEntity<String> deleteJobPosting(@PathVariable String jobPostingId) {
        jobService.deleteJobPosting(jobPostingId);
        return ResponseEntity.ok("Job posting deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        List<JobPosting> jobPostings = jobService.getAllJobPostings();
        return ResponseEntity.ok(jobPostings);
    }
}
