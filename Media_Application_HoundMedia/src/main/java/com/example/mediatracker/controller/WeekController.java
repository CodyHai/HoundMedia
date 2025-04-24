
package com.example.mediatracker.controller;

import com.example.mediatracker.model.Day;
import com.example.mediatracker.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeekController {

    @GetMapping("/week")
    public String showWeek(@RequestParam(defaultValue = "1") int month,
                           @RequestParam(defaultValue = "1") int week,
                           HttpSession session,
                           Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/";

        Day[][][] calendar = user.getYearlySchedule();
        if (month < 1 || month > 12 || week < 1 || week > 4) return "week";

        Day[] weekDays = calendar[month - 1][week - 1];
        model.addAttribute("weekDays", weekDays);
        model.addAttribute("month", month);
        model.addAttribute("week", week);
        return "week";
    }
}
