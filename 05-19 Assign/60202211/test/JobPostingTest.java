package com.example.linkit.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobPostingTest {

    @Test
    void testGettersAndSetters() {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setId("1");
        jobPosting.setTitle("Job Title");
        jobPosting.setDescription("Job Description");
        jobPosting.setTags(new ArrayList<>());
        jobPosting.setCompany("Company");

        assertEquals("1", jobPosting.getId());
        assertEquals("Job Title", jobPosting.getTitle());
        assertEquals("Job Description", jobPosting.getDescription());
        assertEquals(new ArrayList<>(), jobPosting.getTags());
        assertEquals("Company", jobPosting.getCompany());
    }

    @Test
    void testConstructor() {
        List<String> tags = new ArrayList<>();
        JobPosting jobPosting = new JobPosting("1", "Job Title", "Job Description", tags, "Company");

        assertEquals("1", jobPosting.getId());
        assertEquals("Job Title", jobPosting.getTitle());
        assertEquals("Job Description", jobPosting.getDescription());
        assertEquals(tags, jobPosting.getTags());
        assertEquals("Company", jobPosting.getCompany());
    }

    @Test
    void testToString() {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setId("1");
        jobPosting.setTitle("Job Title");

        String expected = "JobPosting{id='1', title='Job Title', description='null', tags=null, company='null'}";
        assertEquals(expected, jobPosting.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        JobPosting jobPosting1 = new JobPosting();
        jobPosting1.setId("1");
        jobPosting1.setTitle("Job Title");

        JobPosting jobPosting2 = new JobPosting();
        jobPosting2.setId("1");
        jobPosting2.setTitle("Job Title");

        assertEquals(jobPosting1, jobPosting2);
        assertEquals(jobPosting1.hashCode(), jobPosting2.hashCode());

        jobPosting2.setId("2");
        assertNotEquals(jobPosting1, jobPosting2);
    }

    @Test
    void testSetters() {
        JobPosting jobPosting = new JobPosting();
        List<String> tags = new ArrayList<>();
        jobPosting.setId("1");
        jobPosting.setTitle("Job Title");
        jobPosting.setDescription("Job Description");
        jobPosting.setTags(tags);
        jobPosting.setCompany("Company");

        assertEquals("1", jobPosting.getId());
        assertEquals("Job Title", jobPosting.getTitle());
        assertEquals("Job Description", jobPosting.getDescription());
        assertEquals(tags, jobPosting.getTags());
        assertEquals("Company", jobPosting.getCompany());
    }
}
