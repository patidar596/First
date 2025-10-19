package com.example.Service;

import com.example.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Dummy authentication logic
    public boolean authenticate(User user) {
        // Replace this with DB lookup if needed
        return "admin".equals(user.getUsername()) && "1234".equals(user.getPassword());
    }
}
