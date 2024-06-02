package com.example.linkit.Service;


import com.example.linkit.Model.NotificationSubject;
import com.example.linkit.Model.Observer;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationSubject notificationSubject = new NotificationSubject();

    public void addObserver(Observer observer) {
        notificationSubject.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        notificationSubject.removeObserver(observer);
    }

    public void sendNotification(String message) {
        notificationSubject.notifyObservers(message);
    }
}
