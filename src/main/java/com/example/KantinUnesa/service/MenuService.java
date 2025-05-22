package com.example.KantinUnesa.service;

import com.example.KantinUnesa.model.Menu;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuService {
    private final Map<String, List<Menu>> menuKantin = new HashMap<>();
    private long idCounter = 1;

    public List<Menu> getMenuByKantin(String namaKantin) {
        return menuKantin.getOrDefault(namaKantin, new ArrayList<>());
    }

    public void tambahMenu(String namaKantin, String namaMenu, int harga) {
        Menu menu = new Menu(idCounter++, namaMenu, harga);
        menuKantin.computeIfAbsent(namaKantin, k -> new ArrayList<>()).add(menu);
    }

    public List<Menu> getMenuByKantinSorted(String namaKantin, String sort) {
        List<Menu> menuList = new ArrayList<>(getMenuByKantin(namaKantin));
        if ("harga_asc".equals(sort)) {
            menuList.sort(Comparator.comparingInt(Menu::getHarga));
        } else if ("harga_desc".equals(sort)) {
            menuList.sort(Comparator.comparingInt(Menu::getHarga).reversed());
        }
        return menuList;
    }
}