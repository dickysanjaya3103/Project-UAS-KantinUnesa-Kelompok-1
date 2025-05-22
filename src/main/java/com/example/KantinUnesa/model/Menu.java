package com.example.KantinUnesa.model;

public class Menu {
    private String nama;
    private int harga;
    private long id;

    public Menu(long id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public long getId() {
        return id;
    }
}