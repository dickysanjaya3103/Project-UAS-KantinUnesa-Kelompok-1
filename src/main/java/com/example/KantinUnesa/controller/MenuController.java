package com.example.KantinUnesa.controller;

import com.example.KantinUnesa.model.Kantin;
import com.example.KantinUnesa.service.KantinService;
import com.example.KantinUnesa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {

    @Autowired
    private KantinService kantinService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu/{nama}")
    public String menuKantin(@PathVariable String nama,
                         @RequestParam(name = "sort", required = false) String sort,
                         Model model, HttpSession session) {
        session.setAttribute("namaKantin", nama);
        Kantin kantin = kantinService.getKantinByNama(nama);
        if (kantin == null) {
            return "redirect:/beranda";
        }
        model.addAttribute("kantin", kantin);
        model.addAttribute("menuList", menuService.getMenuByKantinSorted(nama, sort));
        model.addAttribute("sort", sort);
        return "menu";
    }

    @PostMapping("/menu/{nama}/tambah")
    public String tambahMenu(@PathVariable String nama,
                             @RequestParam String namaMenu,
                             @RequestParam int harga) {
        menuService.tambahMenu(nama, namaMenu, harga);
        return "redirect:/menu/" + nama;
    }
}