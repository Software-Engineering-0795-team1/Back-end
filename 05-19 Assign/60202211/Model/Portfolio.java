package com.example.linkit.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String portfolioLink;


    public Portfolio(String userId, String portfolioLink) {
        this.userId = userId;
        this.portfolioLink = portfolioLink;
    }

    public Portfolio() {}

    public String getUserId() {
        return userId;
    }

    public String getPortfolioLink() {
        return portfolioLink;
    }

    public void setPortfolioLink(String portfolioLink) {
        this.portfolioLink = portfolioLink;
    }
}
