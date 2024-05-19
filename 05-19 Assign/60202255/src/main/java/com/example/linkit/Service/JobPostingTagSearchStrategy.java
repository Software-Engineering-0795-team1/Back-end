package com.example.linkit.Service;

import com.example.linkit.Model.Project;
import com.example.linkit.Repository.JobPostingRepository;
import com.example.linkit.Model.JobPosting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingTagSearchStrategy implements TagSearchStrategy {

    private final JobPostingRepository jobPostingRepository;

    @Autowired
    public JobPostingTagSearchStrategy(JobPostingRepository jobPostingRepository) {
        this.jobPostingRepository = jobPostingRepository;
    }

    @Override
    public List<Project> searchProjectsByTag(String tag) {

        return null;
    }

    @Override
    public List<JobPosting> searchJobPostingsByTags(List<String> tags) {
        // 태그를 기반으로 JobPosting을 검색하는 로직 구현
        return jobPostingRepository.findByTags(tags);
    }
}
