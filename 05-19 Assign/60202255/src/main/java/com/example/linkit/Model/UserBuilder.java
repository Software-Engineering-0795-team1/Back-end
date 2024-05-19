package com.example.linkit.Model;




public class UserBuilder {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Portfolio portfolio;
    private boolean allowProfileView;
    private boolean allowPortfolioView;
    private boolean suspended;

    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setRole(String role) {
        this.role = role;
        return this;
    }

    public UserBuilder setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
        return this;
    }

    public UserBuilder setAllowProfileView(boolean allowProfileView) {
        this.allowProfileView = allowProfileView;
        return this;
    }

    public UserBuilder setAllowPortfolioView(boolean allowPortfolioView) {
        this.allowPortfolioView = allowPortfolioView;
        return this;
    }

    public UserBuilder setSuspended(boolean suspended) {
        this.suspended = suspended;
        return this;
    }

    public User build() {
        return new User(id, name, email, password, role, portfolio, allowProfileView, allowPortfolioView, suspended);
    }
}
