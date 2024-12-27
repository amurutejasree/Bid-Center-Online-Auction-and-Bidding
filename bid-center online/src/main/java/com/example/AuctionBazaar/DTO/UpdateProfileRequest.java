package com.example.AuctionBazaar.DTO;

public class UpdateProfileRequest {
    private String username;
    private String email;

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

