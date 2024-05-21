package com.example.linkit.Model;


public class Permission {
    private String userId;
    private boolean canViewProfile;
    private boolean canViewPortfolio;

    public Permission() {}

    public Permission(String userId, boolean canViewProfile, boolean canViewPortfolio) {
        this.userId = userId;
        this.canViewProfile = canViewProfile;
        this.canViewPortfolio = canViewPortfolio;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isCanViewProfile() {
        return canViewProfile;
    }

    public void setCanViewProfile(boolean canViewProfile) {
        this.canViewProfile = canViewProfile;
    }

    public boolean isCanViewPortfolio() {
        return canViewPortfolio;
    }

    public void setCanViewPortfolio(boolean canViewPortfolio) {
        this.canViewPortfolio = canViewPortfolio;
    }
}
