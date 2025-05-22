package com.example.KantinUnesa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KelompokController {

    @GetMapping("/kelompok")
    public String tampilHalamanKelompok() {
        // Mengarahkan ke templates/kelompok.html
        return "kelompok";
    }
}
