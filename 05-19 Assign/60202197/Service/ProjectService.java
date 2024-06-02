package com.example.linkit.Service;

import com.example.linkit.Model.Project;
import com.example.linkit.Model.User;
import com.example.linkit.Repository.ProjectRepository;
import com.example.linkit.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public Project getProjectById(Long projectId) {
        // 데이터베이스에서 프로젝트 정보를 조회하는 로직
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isPresent()) {
            return project.get();
        } else {
            throw new RuntimeException("Project not found with id: " + projectId);
        }
    }

    public Project createProject(Project project) {
        // 데이터베이스에 새로운 프로젝트 정보를 저장하는 로직
        return projectRepository.save(project);
    }

    public Project updateProject(Long projectId, Project projectDetails) {
        // 데이터베이스에서 프로젝트 정보를 업데이트하는 로직
        Project project = getProjectById(projectId);
        project.setTitle(projectDetails.getTitle());
        project.setDescription(projectDetails.getDescription());
        project.setStatus(projectDetails.getStatus());
        project.setTag(projectDetails.getTag());
        project.setPm(projectDetails.getPm());
        project.setDesigners(projectDetails.getDesigners());
        project.setDevelopers(projectDetails.getDevelopers());
        return projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        // 데이터베이스에서 프로젝트 정보를 삭제하는 로직
        Project project = getProjectById(projectId);
        projectRepository.delete(project);
    }

    public List<Project> getAllProjects() {
        // 데이터베이스에서 모든 프로젝트 정보를 조회하는 로직
        return projectRepository.findAll();
    }

    public List<Project> viewProjects(User user) {
        // 사용자가 볼 수 있는 프로젝트 목록 반환
        return projectRepository.findByPm(user);
    }

    public void applyToProject(Project project, User user) {
        // 사용자가 특정 프로젝트에 지원하는 로직
        if (project.getStatus().equals("Open")) {
            project.getDevelopers().add(user);
            projectRepository.save(project);
        } else {
            throw new RuntimeException("Project is not open for applications.");
        }
    }
}
