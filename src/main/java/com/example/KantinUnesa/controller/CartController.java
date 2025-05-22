package com.example.KantinUnesa.controller;

import com.example.KantinUnesa.model.CartItem;
import com.example.KantinUnesa.model.Kantin;
import com.example.KantinUnesa.service.CartService;
import com.example.KantinUnesa.service.KantinService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {

    private final CartService cartService;
    private final KantinService kantinService;

    public CartController(CartService cartService, KantinService kantinService) {
        this.cartService = cartService;
        this.kantinService = kantinService;
    }

    @PostMapping("/keranjang/tambah")
    public String tambahKeKeranjang(@RequestParam Long id,
                                    @RequestParam String nama,
                                    @RequestParam int harga,
                                    @RequestParam String kantin,
                                    HttpSession session) {
        cartService.addToCart(id, nama, harga, session);
        return "redirect:/menu/" + kantin;
    }

    @GetMapping("/keranjang")
    public String lihatKeranjang(HttpSession session, Model model) {
        List<CartItem> cart = cartService.getCart(session);
        model.addAttribute("cart", cart);
        return "keranjang";
    }

    @PostMapping("/keranjang/checkout")
    public String checkout(HttpSession session, Model model) {
        List<CartItem> cart = cartService.getCart(session);
        model.addAttribute("cart", cart);
        cartService.clearCart(session);
        return "struk";
    }

    @GetMapping("/keranjang/struk")
    public String struk(HttpSession session, Model model) {
        List<CartItem> cart = cartService.getCart(session);
        model.addAttribute("cart", cart);

        String namaKantin = (String) session.getAttribute("namaKantin");
        if (namaKantin != null) {
            Kantin kantin = kantinService.getKantinByNama(namaKantin);
            model.addAttribute("kantin", kantin);
        }
        return "struk";
    }

    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
        String namaKantin = (String) session.getAttribute("namaKantin");
        if (namaKantin != null) {
            model.addAttribute("kantin", kantinService.getKantinByNama(namaKantin));
        }
    }
}