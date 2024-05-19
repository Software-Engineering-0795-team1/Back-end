package com.example.linkit.Service;



import com.example.linkit.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
    public void sendMessage(User sender, User recipient, String message) {
        // 메시지 전송 로직
        System.out.println(sender.getName() + " sent message to " + recipient.getName() + ": " + message);
    }

    public void createChatRoom(List<User> participants) {
        // 채팅방 생성 로직
        System.out.println("Chat room created with participants: " + participants.stream().map(User::getName).collect(Collectors.joining(", ")));
    }
}
