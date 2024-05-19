package com.example.linkit.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ElementCollection
    private List<String> tags;

    @Column(nullable = false)
    private String company;

    // 기본 생성자
    public JobPosting() {
    }

    // 모든 필드를 포함하는 생성자
    public JobPosting(String id, String title, String description, List<String> tags, String company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.company = company;
    }

    // Getter와 Setter 메소드들
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
