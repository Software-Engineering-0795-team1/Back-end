package com.example.linkit.Service;



import com.example.linkit.Model.Admin;
import com.example.linkit.Model.User;
import com.example.linkit.Repository.AdminRepository;
import com.example.linkit.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    public List<User> searchUsersByEmail(String email) {
        return userRepository.findByEmailContaining(email);
    }

    public void suspendUser(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setSuspended(true);
            userRepository.save(user);
        }
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
