package com.example.linkit.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String title;
    private String description;
    private String status;

    @ManyToOne
    private User pm;

    @ManyToMany
    private List<User> designers;

    @ManyToMany
    private List<User> developers;

    public Project() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getPm() {
        return pm;
    }

    public void setPm(User pm) {
        this.pm = pm;
    }

    public List<User> getDesigners() {
        return designers;
    }

    public void setDesigners(List<User> designers) {
        this.designers = designers;
    }

    public List<User> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<User> developers) {
        this.developers = developers;
    }
}
