package com.example.linkit.Service;

import com.example.linkit.Model.Project;
import com.example.linkit.Model.User;
import com.example.linkit.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project getProjectById(String projectId) {
        // 실제로는 데이터베이스에서 프로젝트 정보를 조회하는 로직이 필요합니다.
        return new Project();
    }

    public void createProject(Project project) {
        // 프로젝트 생성 로직
    }

    public void updateProject(String projectId, Project project) {
        // 프로젝트 수정 로직
    }

    public void deleteProject(String projectId) {
        // 프로젝트 삭제 로직
    }

    public List<Project> getAllProjects() {
        // 모든 프로젝트 조회 로직
        return projectRepository.findAll();
    }

    public List<Project> viewProjects(User user) {
        // 사용자가 볼 수 있는 프로젝트 목록 반환
        return projectRepository.findAll();
    }

    public void applyToProject(Project project, User user) {
        // 프로젝트 신청 로직
        System.out.println(user.getName() + " applied to project " + project.getTitle());
    }
}
