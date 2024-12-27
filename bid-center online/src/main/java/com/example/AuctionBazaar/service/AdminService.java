package com.example.AuctionBazaar.service;

import com.example.AuctionBazaar.Model.User;
import com.example.AuctionBazaar.Model.Auction;
import com.example.AuctionBazaar.Model.Bid;
import com.example.AuctionBazaar.repository.UserRepository;
import com.example.AuctionBazaar.repository.AuctionRepository;
import com.example.AuctionBazaar.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private BidRepository bidRepository;

    // User management
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public User updateUser(Long userId, User userDetails) {
        User user = getUserById(userId);
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        // Update other user fields as needed
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(Math.toIntExact(userId));
    }

    // Auction management
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Auction getAuctionById(Long auctionId) {
        return auctionRepository.findById(auctionId)
                .orElseThrow(() -> new NoSuchElementException("Auction not found"));
    }

    public Auction updateAuction(Long auctionId, Auction auctionDetails) {
        Auction auction = getAuctionById(auctionId);
        auction.setTitle(auctionDetails.getTitle());
        auction.setDescription(auctionDetails.getDescription());
        // Update other auction fields as needed
        return auctionRepository.save(auction);
    }

    public void deleteAuction(Long auctionId) {
        auctionRepository.deleteById(auctionId);
    }

    // Bid management
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid getBidById(Long bidId) {
        return bidRepository.findById(bidId)
                .orElseThrow(() -> new NoSuchElementException("Bid not found"));
    }

    public void deleteBid(Long bidId) {
        bidRepository.deleteById(bidId);
    }
}

