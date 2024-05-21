package com.example.linkit.Repository;

import com.example.linkit.Model.Project;
import com.example.linkit.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByStatus(String status);
    List<Project> findByPm(User pm);
    List<Project> findByTagContaining(String tag);
}
