package com.example.linkit.Service;

import com.example.linkit.Model.Project;
import com.example.linkit.Model.JobPosting;

import java.util.List;

public interface TagSearchStrategy {
    List<Project> searchProjectsByTag(String tags);
    List<JobPosting> searchJobPostingsByTags(List<String> tags);
}
