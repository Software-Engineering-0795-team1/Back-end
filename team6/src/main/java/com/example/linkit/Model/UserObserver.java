package com.example.linkit.Model;


public class UserObserver implements Observer {
    private String email;

    public UserObserver(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        // 이메일로 알림을 보내는 로직 구현
        System.out.println("Sending email to " + email + ": " + message);
    }
}
