package com.example.AuctionBazaar.DTO;

public class ResetPasswordRequest {
    private String token;
    private String newPassword;

    public String getToken() {
        return token;
    }

    public String getNewPassword() {
        return newPassword;
    }
    // Getters and setters
}
