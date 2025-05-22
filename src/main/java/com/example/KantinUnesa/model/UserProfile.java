package com.example.KantinUnesa.model;

public class UserProfile {
    private String username;
    private String email;
    private String namaLengkap;

    public UserProfile() {}

    public UserProfile(String username, String email, String namaLengkap) {
        this.username = username;
        this.email = email;
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }
}
