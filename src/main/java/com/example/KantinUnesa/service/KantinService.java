package com.example.KantinUnesa.service;

import com.example.KantinUnesa.model.Kantin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KantinService {
    private final List<Kantin> daftarKantin = new ArrayList<>();

    public KantinService() {
        // Data awal (jika ada)
        daftarKantin.add(new Kantin("Es Teh Duo", "Minuman · Teh · Camilan", "/images/454234.jpeg"));
        daftarKantin.add(new Kantin("Geprekan Aja", "Ayam Geprek · Nasi Goreng", "/images/3069119953.jpg"));
    }

    public List<Kantin> getAllKantin(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return daftarKantin;
        }
        return daftarKantin.stream()
                .filter(k -> k.getNama().toLowerCase().contains(keyword.toLowerCase())
                        || k.getDeskripsi().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void tambahKantin(String nama, String deskripsi, String gambar) {
    daftarKantin.add(new Kantin(nama, deskripsi, gambar));
    }
    public Kantin getKantinByNama(String nama) {
    return daftarKantin.stream()
        .filter(k -> k.getNama().equalsIgnoreCase(nama))
        .findFirst()
        .orElse(null);
    }
    public void hapusKantin(String nama) {
        daftarKantin.removeIf(k -> k.getNama().equalsIgnoreCase(nama))  ;
    }
    public List<Kantin> getAllKantin() {
        return daftarKantin;
    }
}
