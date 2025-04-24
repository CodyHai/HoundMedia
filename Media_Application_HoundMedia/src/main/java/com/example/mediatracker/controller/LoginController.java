
package com.example.mediatracker.controller;

import com.example.mediatracker.model.User;
import com.example.mediatracker.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        User user = UserRepository.findByUsername(username);
        System.out.println("login user: " + username + " / " + password);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //System.out.println("Registered user: " + user.getUsername() + " / " + user.getPassword());
        System.out.println("User map after logout: " + UserRepository.findByUsername("sd"));
        session.invalidate();
        System.out.println("User map after logout: " + UserRepository.findByUsername("sd"));
        return "redirect:/";
    }
}
