package com.example.KantinUnesa.service;

import com.example.KantinUnesa.model.CartItem;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CartService {

    public List<CartItem> getCart(HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        return cart;
    }

    public void addToCart(Long id, String nama, int harga, HttpSession session) {
        List<CartItem> cart = getCart(session);
        boolean found = false;
        for (CartItem item : cart) {
            if (item.getId().equals(id)) {
                item.setQty(item.getQty() + 1);
                found = true;
                break;
            }
        }
        if (!found) {
            CartItem item = new CartItem(id, nama, harga, 1);
            cart.add(item);
        }
        session.setAttribute("cart", cart);
    }

    public void clearCart(HttpSession session) {
        session.removeAttribute("cart");
    }
}