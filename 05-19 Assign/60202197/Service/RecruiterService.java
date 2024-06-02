package com.example.linkit.Service;

import com.example.linkit.Model.User;
import com.example.linkit.Model.Portfolio;
import com.example.linkit.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {
    private final UserRepository userRepository;

    @Autowired
    public RecruiterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User viewUserProfile(String recruiterId, String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && user.isAllowProfileView()) {
            return user;
        }
        return null;
    }

    public Portfolio viewUserPortfolio(String recruiterId, String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && user.isAllowPortfolioView()) {
            return user.getPortfolio();
        }
        return null;
    }
}
