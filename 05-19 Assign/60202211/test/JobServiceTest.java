package com.example.linkit.Service;

import com.example.linkit.Model.JobPosting;
import com.example.linkit.Repository.JobPostingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobServiceTest {

    @Mock
    private JobPostingRepository jobPostingRepository;

    @InjectMocks
    private JobService jobService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetJobPostingById() {
        JobPosting jobPosting = new JobPosting("1", "Job Title", "Job Description", new ArrayList<>(), "Company");
        when(jobPostingRepository.findById("1")).thenReturn(Optional.of(jobPosting));

        JobPosting result = jobService.getJobPostingById("1");
        assertNotNull(result);
        assertEquals("Job Title", result.getTitle());
    }

    @Test
    void testCreateJobPosting() {
        JobPosting jobPosting = new JobPosting("1", "Job Title", "Job Description", new ArrayList<>(), "Company");
        when(jobPostingRepository.save(any(JobPosting.class))).thenReturn(jobPosting);

        jobService.createJobPosting(jobPosting);
        verify(jobPostingRepository, times(1)).save(jobPosting);
    }

    @Test
    void testUpdateJobPosting() {
        JobPosting jobPosting = new JobPosting("1", "Job Title", "Job Description", new ArrayList<>(), "Company");
        JobPosting updatedJobPosting = new JobPosting("1", "Updated Title", "Updated Description", new ArrayList<>(), "Company");
        when(jobPostingRepository.findById("1")).thenReturn(Optional.of(jobPosting));
        when(jobPostingRepository.save(any(JobPosting.class))).thenReturn(updatedJobPosting);

        jobService.updateJobPosting("1", updatedJobPosting);
        verify(jobPostingRepository, times(1)).save(jobPosting);
    }

    @Test
    void testDeleteJobPosting() {
        JobPosting jobPosting = new JobPosting("1", "Job Title", "Job Description", new ArrayList<>(), "Company");
        when(jobPostingRepository.findById("1")).thenReturn(Optional.of(jobPosting));

        jobService.deleteJobPosting("1");
        verify(jobPostingRepository, times(1)).deleteById("1");
    }

    @Test
    void testGetAllJobPostings() {
        JobPosting jobPosting1 = new JobPosting("1", "Job Title 1", "Job Description 1", new ArrayList<>(), "Company 1");
        JobPosting jobPosting2 = new JobPosting("2", "Job Title 2", "Job Description 2", new ArrayList<>(), "Company 2");
        List<JobPosting> jobPostings = List.of(jobPosting1, jobPosting2);
        when(jobPostingRepository.findAll()).thenReturn(jobPostings);

        List<JobPosting> result = jobService.getAllJobPostings();
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
