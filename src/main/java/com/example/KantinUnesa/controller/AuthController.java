package com.example.KantinUnesa.controller;

import com.example.KantinUnesa.service.UserService;
import com.example.KantinUnesa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        if (userService.validateUser(username, password)) {
            session.setAttribute("username", username);
            return "redirect:/beranda";
        } else {
            model.addAttribute("error", "Login gagal. Cek username/password.");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        User user = new User(username, password);
        boolean success = userService.registerUser(user);
        if (success) {
            return "redirect:/beranda";
        } else {
            model.addAttribute("error", "Username sudah terdaftar.");
            return "register";
        }
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    session.invalidate(); // Hapus semua data session
    return "redirect:/login"; // Arahkan ke halaman login
    }

}