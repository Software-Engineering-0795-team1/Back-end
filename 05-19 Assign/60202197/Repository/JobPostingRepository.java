package com.example.linkit.Repository;

import com.example.linkit.Model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, String> {
    List<JobPosting> findByTags(List<String> tags);
}
