package com.example.AuctionBazaar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

//import java.security.Timestamp;
import java.net.URL;
import java.sql.Timestamp;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId;
    private String username;
    private String email;
    private String passwordHash;
    private String resetToken;
    private Timestamp tokenExpiry;
    private Timestamp lastLogin;
    private Timestamp createdAt;
    private Boolean isLoggedin;

    // Getters
    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getResetToken() {
        return resetToken;
    }

    public Timestamp getTokenExpiry() {
        return tokenExpiry;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Boolean getIsLoggedin() {
        return isLoggedin;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public void setTokenExpiry(Timestamp tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setIsLoggedin(Boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }


    public void setUpdatedAt(Timestamp timestamp) {

    }
}

