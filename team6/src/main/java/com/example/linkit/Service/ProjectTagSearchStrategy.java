package com.example.linkit.Service;

import com.example.linkit.Model.Project;
import com.example.linkit.Repository.ProjectRepository;
import com.example.linkit.Model.JobPosting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTagSearchStrategy implements TagSearchStrategy {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectTagSearchStrategy(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> searchProjectsByTag(String tag) {
        // 태그를 기반으로 프로젝트를 검색하는 로직 구현
        return projectRepository.findProjectByTag(tag);
    }

    @Override
    public List<JobPosting> searchJobPostingsByTags(List<String> tags) {

        return null;
    }
}
