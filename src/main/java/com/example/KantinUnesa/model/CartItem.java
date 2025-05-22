package com.example.KantinUnesa.model;
public class CartItem {
    private Long id;
    private String nama;
    private int harga;
    private int qty;
    
    public CartItem(Long id, String nama, int harga, int qty) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.qty = qty;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    
}
