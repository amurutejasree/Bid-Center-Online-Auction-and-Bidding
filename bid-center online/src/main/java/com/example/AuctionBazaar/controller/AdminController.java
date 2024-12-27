package com.example.AuctionBazaar.controller;

import com.example.AuctionBazaar.Model.User;
import com.example.AuctionBazaar.Model.Auction;
import com.example.AuctionBazaar.Model.Bid;
import com.example.AuctionBazaar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // User management endpoints
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return adminService.getUserById(userId);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        return adminService.updateUser(userId, userDetails);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        adminService.deleteUser(userId);
        return "User deleted successfully";
    }

    // Auction management endpoints
    @GetMapping("/auctions")
    public List<Auction> getAllAuctions() {
        return adminService.getAllAuctions();
    }

    @GetMapping("/auctions/{auctionId}")
    public Auction getAuctionById(@PathVariable Long auctionId) {
        return adminService.getAuctionById(auctionId);
    }

    @PutMapping("/auctions/{auctionId}")
    public Auction updateAuction(@PathVariable Long auctionId, @RequestBody Auction auctionDetails) {
        return adminService.updateAuction(auctionId, auctionDetails);
    }

    @DeleteMapping("/auctions/{auctionId}")
    public String deleteAuction(@PathVariable Long auctionId) {
        adminService.deleteAuction(auctionId);
        return "Auction deleted successfully";
    }

    // Bid management endpoints
    @GetMapping("/bids")
    public List<Bid> getAllBids() {
        return adminService.getAllBids();
    }

    @GetMapping("/bids/{bidId}")
    public Bid getBidById(@PathVariable Long bidId) {
        return adminService.getBidById(bidId);
    }

    @DeleteMapping("/bids/{bidId}")
    public String deleteBid(@PathVariable Long bidId) {
        adminService.deleteBid(bidId);
        return "Bid deleted successfully";
    }
}
