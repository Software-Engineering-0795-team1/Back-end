package com.example.linkit.Service;

import com.example.linkit.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacade {
    private final ProjectService projectService;
    private final ChatService chatService;
    private final JobService jobService;
    private final PortfolioService portfolioService;
    private final TagSearchStrategyFactory tagSearchStrategyFactory;
    private final UserService userService;

    @Autowired
    public UserFacade(ProjectService projectService, ChatService chatService, JobService jobService, PortfolioService portfolioService, TagSearchStrategyFactory tagSearchStrategyFactory, UserService userService) {
        this.projectService = projectService;
        this.chatService = chatService;
        this.jobService = jobService;
        this.portfolioService = portfolioService;
        this.tagSearchStrategyFactory = tagSearchStrategyFactory;
        this.userService = userService;
    }

    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    public Project getProjectById(String projectId) {
        return projectService.getProjectById(projectId);
    }

    public List<Project> viewProjects(String userId) {
        User user = getUserById(userId);
        return projectService.viewProjects(user);
    }

    public void applyToProject(String userId, String projectId) {
        User user = getUserById(userId);
        Project project = getProjectById(projectId);
        projectService.applyToProject(project, user);
    }

    public void sendMessage(String senderId, String recipientId, String message) {
        User sender = getUserById(senderId);
        User recipient = getUserById(recipientId);
        chatService.sendMessage(sender, recipient, message);
    }

    public void createChatRoom(List<String> participantIds) {
        List<User> participants = participantIds.stream().map(this::getUserById).toList();
        chatService.createChatRoom(participants);
    }

    public List<JobPosting> viewJobPostings(String userId) {
        User user = getUserById(userId);
        return jobService.viewJobPostings(user);
    }

    public void uploadPortfolio(String userId, String filePath) {
        User user = getUserById(userId);
        String portfolioLink = portfolioService.uploadPortfolio(filePath);
        Portfolio portfolio = new Portfolio(user.getId(), portfolioLink);
        user.setPortfolio(portfolio);
    }

    public List<Project> searchProjectsByTags(String tag) {
        TagSearchStrategy strategy = tagSearchStrategyFactory.getStrategy("project");
        return strategy.searchProjectsByTag(tag);
    }

    public List<JobPosting> searchJobPostingsByTags(List<String> tags) {
        TagSearchStrategy strategy = tagSearchStrategyFactory.getStrategy("jobPosting");
        return strategy.searchJobPostingsByTags(tags);
    }
}
