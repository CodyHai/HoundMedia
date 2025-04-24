
package com.example.mediatracker.controller;
import com.example.mediatracker.repository.UserRepository;
import com.example.mediatracker.model.Media;
import com.example.mediatracker.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("/home")
    public String showHome(HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/";
        return "home";
    }

    @PostMapping("/addMedia")
    public String addMedia(@RequestParam(required = false) Integer month,
                           @RequestParam(required = false) Integer day,
                           @RequestParam String name,
                           @RequestParam String tag,
                           @RequestParam(required = false) Double length,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){

        if (month == null || day == null || name == null || tag == null || length == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid media entry. Please check all fields.");
            return  "redirect:/home";
        }

        if(day < 1 || day > 28 || month < 1 || month > 12){
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid media entry. Please check all fields.");
            return "redirect:/home";
        }

        if(name.length() > 25 || tag.length() > 25){
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid media entry. Please check all fields.");
            return "redirect:/home";
        }
       //check for more than 2 decimals

        String str = Double.toString(length);
        String delimiter = "\\.";
        if(str.contains(".")) {
            String[] parts = str.split(delimiter, 2);
            if (parts[1].length() > 2) {
                redirectAttributes.addFlashAttribute("errorMessage", "Invalid media entry. Please check all fields.");
                return "redirect:/home";
            }
        }
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/";
        int m = month - 1;
        int d = day - 1;
        int week = d / 7;
        int dayOfWeek = d % 7;
        user.getYearlySchedule()[m][week][dayOfWeek].addMedia(new Media(name, tag, length));
        UserRepository.save(user);
        return "redirect:/home";
    }
}
