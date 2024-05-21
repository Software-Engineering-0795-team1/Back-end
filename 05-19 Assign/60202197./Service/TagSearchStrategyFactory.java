package com.example.linkit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagSearchStrategyFactory {

    private final ProjectTagSearchStrategy projectTagSearchStrategy;
    private final JobPostingTagSearchStrategy jobPostingTagSearchStrategy;

    @Autowired
    public TagSearchStrategyFactory(ProjectTagSearchStrategy projectTagSearchStrategy, JobPostingTagSearchStrategy jobPostingTagSearchStrategy) {
        this.projectTagSearchStrategy = projectTagSearchStrategy;
        this.jobPostingTagSearchStrategy = jobPostingTagSearchStrategy;
    }

    public TagSearchStrategy getStrategy(String type) {
        if ("project".equalsIgnoreCase(type)) {
            return projectTagSearchStrategy;
        } else if ("jobPosting".equalsIgnoreCase(type)) {
            return jobPostingTagSearchStrategy;
        }
        throw new IllegalArgumentException("Unknown strategy type: " + type);
    }
}
