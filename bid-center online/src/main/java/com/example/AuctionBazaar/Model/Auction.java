package com.example.AuctionBazaar.Model;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "auctions")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;

    private Long ownerId;
    private Long categoryId;
    private String title;
    private String description;
    private BigDecimal startPrice;
    private BigDecimal currentPrice;
    private Timestamp startTime;
    private Timestamp endTime;

    @Enumerated(EnumType.STRING)  // Ensure this annotation remains here
    private AuctionStatus status; // Use the custom AuctionStatus enum here

    private Long winnerUserId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}

// Getters and Setters, etc.
