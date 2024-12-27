package com.example.AuctionBazaar.service;

import com.example.AuctionBazaar.Model.Auction;
import com.example.AuctionBazaar.Model.Bid;
import com.example.AuctionBazaar.repository.AuctionRepository;
import com.example.AuctionBazaar.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    public Bid placeBid(Long auctionId, Long userId, BigDecimal bidAmount) {
        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new NoSuchElementException("Auction with ID " + auctionId + " not found"));

        if (bidAmount.compareTo(auction.getCurrentPrice()) > 0) {
            auction.setCurrentPrice(bidAmount);
            auctionRepository.save(auction); // Update the auction's current price

            Bid bid = new Bid(auctionId, userId, bidAmount, new Timestamp(System.currentTimeMillis()));
            return bidRepository.save(bid); // Save the new bid
        } else {
            throw new IllegalArgumentException("Bid amount must be higher than the current price");
        }
    }

    public List<Bid> getBidsByAuctionId(Long auctionId) {
        return bidRepository.findByAuctionId(auctionId); // Retrieve all bids for an auction
    }
}