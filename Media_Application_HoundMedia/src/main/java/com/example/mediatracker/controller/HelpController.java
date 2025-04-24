package com.example.mediatracker.controller;

import com.example.mediatracker.model.HelpRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HelpController {

    // Show the help form
    @GetMapping("/help")
    public String help(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        // Only add empty HelpRequest if one doesn't exist (i.e., after redirect)
        if (!model.containsAttribute("helpRequest")) {
            model.addAttribute("helpRequest", new HelpRequest());
        }

        return "help";
    }

    // Handle help form submission
    @PostMapping("/help")
    public String submitHelpForm(@Valid @ModelAttribute("helpRequest") HelpRequest helpRequest,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes,
                                 HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            // Preserve validation errors and original input
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.helpRequest", result);
            redirectAttributes.addFlashAttribute("helpRequest", helpRequest);
            return "redirect:/help";
        }

        // Add success message after redirect
        redirectAttributes.addFlashAttribute("success", "Your message has been received!");
        return "redirect:/help";
    }
}
