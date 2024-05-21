package com.example.linkit.Controller;

import com.example.linkit.Model.Admin;
import com.example.linkit.Model.User;
import com.example.linkit.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok(createdAdmin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully");
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<User>> searchUsersByName(@RequestParam String name) {
        List<User> users = adminService.searchUsersByName(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<List<User>> searchUsersByEmail(@RequestParam String email) {
        List<User> users = adminService.searchUsersByEmail(email);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/suspend/{userId}")
    public ResponseEntity<String> suspendUser(@PathVariable String userId) {
        adminService.suspendUser(userId);
        return ResponseEntity.ok("User suspended successfully");
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        adminService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
