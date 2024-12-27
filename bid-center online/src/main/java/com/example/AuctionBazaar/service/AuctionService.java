package com.example.AuctionBazaar.service;

import com.example.AuctionBazaar.Model.Auction;
import com.example.AuctionBazaar.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;

    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public Optional<Auction> updateAuction(Long auctionId, Auction updatedAuction) {
        return auctionRepository.findById(auctionId).map(auction -> {
            auction.setTitle(updatedAuction.getTitle());
            auction.setDescription(updatedAuction.getDescription());
            auction.setCurrentPrice(updatedAuction.getCurrentPrice());
            auction.setEndTime(updatedAuction.getEndTime());
            return auctionRepository.save(auction);
        });
    }

    public void deleteAuction(Long auctionId) {
        auctionRepository.deleteById(auctionId);
    }
}