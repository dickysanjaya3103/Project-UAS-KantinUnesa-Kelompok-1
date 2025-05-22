package com.example.KantinUnesa.model;

public class Kantin {
    private String nama;
    private String deskripsi;
    private String gambar;

    public Kantin(String nama, String deskripsi, String gambar) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getGambar() {
        return gambar;
    }
}
