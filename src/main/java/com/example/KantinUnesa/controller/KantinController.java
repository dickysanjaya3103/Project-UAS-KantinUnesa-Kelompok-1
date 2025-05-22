package com.example.KantinUnesa.controller;

import com.example.KantinUnesa.service.KantinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class KantinController {

    @Autowired
    private KantinService kantinService;

    @PostMapping("/kantin/tambah")
    public String tambahKantin(@RequestParam String nama,
                               @RequestParam String deskripsi,
                               @RequestParam("gambar") MultipartFile gambar) throws IOException {
        // Simpan file gambar ke folder uploads
        String fileName = UUID.randomUUID() + "_" + gambar.getOriginalFilename();
        Path uploadPath = Paths.get("uploads");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        gambar.transferTo(uploadPath.resolve(fileName));
        // Simpan data ke service
        kantinService.tambahKantin(nama, deskripsi, "/uploads/" + fileName);
        return "redirect:/beranda";
    }
}