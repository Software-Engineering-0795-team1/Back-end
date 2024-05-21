package com.example.linkit.Service;



import com.example.linkit.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserById(String userId) {
        // 실제로는 데이터베이스에서 사용자 정보를 조회하는 로직이 필요

        return new User(userId, "exampleName", "exampleEmail", "examplePassword", "exampleRole");
    }
}