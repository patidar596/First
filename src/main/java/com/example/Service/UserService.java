package com.example.Service;

import com.example.Model.User;
import com.example.Model.UserTable;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Dummy authentication logic
    public boolean authenticate(User user) {
        // Replace this with DB lookup if needed
        return "admin".equals(user.getUsername()) && "1234".equals(user.getPassword());
    }

    public boolean isUserAvailable(String username, String password){
        UserTable user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
