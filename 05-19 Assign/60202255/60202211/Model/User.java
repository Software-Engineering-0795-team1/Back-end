package com.example.linkit.Model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role; // PM, Designer, Developer, Recruiter

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Portfolio portfolio;

    private boolean allowProfileView;
    private boolean allowPortfolioView;

    private boolean suspended;

    // 기본 생성자
    public User() {}

    // 모든 필드를 포함하는 생성자
    public User(String id, String name, String email, String password, String role, Portfolio portfolio, boolean allowProfileView, boolean allowPortfolioView, boolean suspended) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.portfolio = portfolio;
        this.allowProfileView = allowProfileView;
        this.allowPortfolioView = allowPortfolioView;
        this.suspended = suspended;
    }

    public User(String id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public boolean isAllowProfileView() {
        return allowProfileView;
    }

    public void setAllowProfileView(boolean allowProfileView) {
        this.allowProfileView = allowProfileView;
    }

    public boolean isAllowPortfolioView() {
        return allowPortfolioView;
    }

    public void setAllowPortfolioView(boolean allowPortfolioView) {
        this.allowPortfolioView = allowPortfolioView;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }
}
