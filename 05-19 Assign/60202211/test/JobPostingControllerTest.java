package com.example.linkit.Controller;

import com.example.linkit.Model.JobPosting;
import com.example.linkit.Service.JobService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JobPostingController.class)
class JobPostingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobService jobService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllJobPostings() throws Exception {
        JobPosting jobPosting1 = new JobPosting("1", "Job Title 1", "Job Description 1", new ArrayList<>(), "Company 1");
        JobPosting jobPosting2 = new JobPosting("2", "Job Title 2", "Job Description 2", new ArrayList<>(), "Company 2");

        List<JobPosting> jobPostings = List.of(jobPosting1, jobPosting2);

        given(jobService.getAllJobPostings()).willReturn(jobPostings);

        mockMvc.perform(get("/jobPosting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Job Title 1"))
                .andExpect(jsonPath("$[1].title").value("Job Title 2"));
    }

    @Test
    void testGetJobPostingById() throws Exception {
        JobPosting jobPosting = new JobPosting("1", "Job Title", "Job Description", new ArrayList<>(), "Company");

        given(jobService.getJobPostingById("1")).willReturn(jobPosting);

        mockMvc.perform(get("/jobPosting/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Job Title"));
    }

    @Test
    void testCreateJobPosting() throws Exception {
        JobPosting jobPosting = new JobPosting("1", "Job Title", "Job Description", new ArrayList<>(), "Company");

        given(jobService.createJobPosting(jobPosting)).willReturn(jobPosting);

        mockMvc.perform(post("/jobPosting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jobPosting)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Job Title"));
    }

    @Test
    void testUpdateJobPosting() throws Exception {
        JobPosting jobPosting = new JobPosting("1", "Updated Title", "Updated Description", new ArrayList<>(), "Company");

        given(jobService.updateJobPosting("1", jobPosting)).willReturn(jobPosting);

        mockMvc.perform(put("/jobPosting/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jobPosting)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Title"));
    }

    @Test
    void testDeleteJobPosting() throws Exception {
        mockMvc.perform(delete("/jobPosting/1"))
                .andExpect(status().isOk());
        verify(jobService).deleteJobPosting("1");
    }
}
