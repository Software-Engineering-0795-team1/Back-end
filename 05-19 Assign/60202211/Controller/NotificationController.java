package com.example.linkit.Controller;

import com.example.linkit.Model.UserObserver;
import com.example.linkit.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam String email) {
        UserObserver userObserver = new UserObserver(email);
        notificationService.addObserver(userObserver);
        return ResponseEntity.ok("Subscribed successfully");
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<String> unsubscribe(@RequestParam String email) {
        UserObserver userObserver = new UserObserver(email);
        notificationService.removeObserver(userObserver);
        return ResponseEntity.ok("Unsubscribed successfully");
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam String message) {
        notificationService.sendNotification(message);
        return ResponseEntity.ok("Notification sent successfully");
    }
}
