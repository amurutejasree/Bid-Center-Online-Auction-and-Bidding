package com.example.AuctionBazaar.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "auction_images")
public class AuctionImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private Long auctionId;
    private String imageUrl;
    private Boolean isPrimary;

    private Timestamp uploadedAt;

    // Getters and Setters, etc.
}
