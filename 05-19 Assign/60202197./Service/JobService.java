package com.example.linkit.Service;
import com.example.linkit.Model.JobPosting;
import com.example.linkit.Repository.JobPostingRepository;
import com.example.linkit.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobPostingRepository jobPostingRepository;

    @Autowired
    public JobService(JobPostingRepository jobPostingRepository) {
        this.jobPostingRepository = jobPostingRepository;
    }

    public JobPosting getJobPostingById(String jobPostingId) {
        // 데이터베이스에서 채용 공고를 조회하는 로직이 필요
        return jobPostingRepository.findById(jobPostingId).orElse(null);
    }

    public void createJobPosting(JobPosting jobPosting) {
        // 채용 공고 생성 로직
        jobPostingRepository.save(jobPosting);
    }

    public void updateJobPosting(String jobPostingId, JobPosting updatedJobPosting) {
        // 채용 공고 수정 로직 (임시 메소드 ) API 사용 예정
        JobPosting jobPosting = getJobPostingById(jobPostingId);
        if (jobPosting != null) {
            jobPosting.setTitle(updatedJobPosting.getTitle());
            jobPosting.setDescription(updatedJobPosting.getDescription());
            jobPosting.setTags(updatedJobPosting.getTags());
            jobPosting.setCompany(updatedJobPosting.getCompany());
            jobPostingRepository.save(jobPosting);
        }
    }

    public void deleteJobPosting(String jobPostingId) {
        // 채용 공고 삭제 로직
        jobPostingRepository.deleteById(jobPostingId);
    }

    public List<JobPosting> getAllJobPostings() {
        // 모든 채용 공고 조회 로직
        return jobPostingRepository.findAll();
    }

    public List<JobPosting> viewJobPostings(User user) {
        // 사용자가 볼 수 있는 채용 공고 목록 반환
        return jobPostingRepository.findAll();
    }
}
