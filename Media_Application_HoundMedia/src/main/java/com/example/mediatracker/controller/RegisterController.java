/*package com.example.mediatracker.controller;

import com.example.mediatracker.model.User;
import com.example.mediatracker.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           HttpSession session,
                           Model modelAttr) {
        if (UserRepository.exists(user.getUsername())) {
            result.rejectValue("username", null, "Username already exists.");
        }

        if (result.hasErrors()) {
            return "register";
        }

        UserRepository.save(user);
        session.setAttribute("user", user);
        return "redirect:/home";
    }
}


*/



package com.example.mediatracker.controller;


import com.example.mediatracker.model.User;
import com.example.mediatracker.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           HttpSession session) {
        if (username == null || username.isBlank() || username.length() > 25 ||
                password == null || password.isBlank() || password.length() > 25) {
            return "register";
        }

        if (!UserRepository.exists(username)) {
            User user = new User(username, password);
            user.initializeSchedule();
            UserRepository.save(user);
            session.setAttribute("user", user);
            return "redirect:/home";
        }


        return "register"; // Optionally show error
    }
}
