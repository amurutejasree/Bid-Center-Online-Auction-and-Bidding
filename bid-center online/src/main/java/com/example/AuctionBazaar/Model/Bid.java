package com.example.AuctionBazaar.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bidId;

    private Long auctionId;
    private Long userId;
    private BigDecimal bidAmount;

    @Column(name = "bid_time")
    private Timestamp bidTime;

    public Bid() {}

    public Bid(Long auctionId, Long userId, BigDecimal bidAmount, Timestamp bidTime) {
        this.auctionId = auctionId;
        this.userId = userId;
        this.bidAmount = bidAmount;
        this.bidTime = bidTime;
    }

    // Getters for each field

    public Long getBidId() {
        return bidId;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public Long getUserId() {
        return userId;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public Timestamp getBidTime() {
        return bidTime;
    }
}
