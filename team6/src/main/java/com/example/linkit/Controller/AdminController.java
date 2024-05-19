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

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<User>> searchUsersByName(@RequestParam String name) {

        return null;
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<List<User>> searchUsersByEmail(@RequestParam String email) {

        return null;
    }

    @PostMapping("/suspend/{userId}")
    public ResponseEntity<String> suspendUser(@PathVariable String userId) {

        return null;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {

        return null;
    }
}
