package com.example.Controller;

import com.example.Model.TestModel;
import com.example.Model.User;
import com.example.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(){
        return "testy";
    }

    @GetMapping("/test2")
    public TestModel test2() {
        TestModel testModel = new TestModel();
        testModel.setTest("1234");
        return testModel;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User user, HttpSession session, Model model) {
        if (userService.authenticate(user)) {
            session.setAttribute("username", user.getUsername());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "home";
    }
}
