package com.example.KantinUnesa.controller;

import com.example.KantinUnesa.service.KantinService;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class BerandaController {

    private final KantinService kantinService;

    public BerandaController(KantinService kantinService) {
        this.kantinService = kantinService;
    }

    @GetMapping("/beranda")
    public String beranda(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("kantinList", kantinService.getAllKantin(keyword));
        return "beranda";
    }

    @PostMapping("/beranda/tambah")
public String tambahKantin(@RequestParam String nama,
                           @RequestParam String deskripsi,
                           @RequestParam("gambar") MultipartFile gambar) throws IOException {
    // Simpan file gambar ke folder uploads
    String fileName = java.util.UUID.randomUUID() + "_" + gambar.getOriginalFilename();
    java.nio.file.Path uploadPath = java.nio.file.Paths.get("uploads");
    if (!java.nio.file.Files.exists(uploadPath)) {
        java.nio.file.Files.createDirectories(uploadPath);
    }
    gambar.transferTo(uploadPath.resolve(fileName));
    // Simpan data ke service
    kantinService.tambahKantin(nama, deskripsi, "/uploads/" + fileName);
    return "redirect:/beranda";
}

@PostMapping("/beranda/hapus")
public String hapusKantin(@RequestParam String nama) {
    kantinService.hapusKantin(nama);
    return "redirect:/beranda";
}

// ...existing code...
}
