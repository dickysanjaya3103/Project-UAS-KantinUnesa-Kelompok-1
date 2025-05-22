package com.example.KantinUnesa.controller;

import com.example.KantinUnesa.model.UserProfile;
import com.example.KantinUnesa.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profil")
    public String profil(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        UserProfile profile = profileService.getProfile(username);
        model.addAttribute("profile", profile);
        return "profil";
    }

    @GetMapping("/pengaturan")
    public String pengaturan(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        UserProfile profile = profileService.getProfile(username);
        model.addAttribute("profile", profile);
        return "pengaturan";
    }

    @PostMapping("/pengaturan")
    public String updatePengaturan(@ModelAttribute UserProfile profile, HttpSession session) {
        String username = (String) session.getAttribute("username");
        profile.setUsername(username); // pastikan username tidak berubah
        profileService.updateProfile(profile);
        return "redirect:/profil";
    }
}
