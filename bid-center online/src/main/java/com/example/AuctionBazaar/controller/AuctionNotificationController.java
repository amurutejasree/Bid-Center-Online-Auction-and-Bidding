package com.example.AuctionBazaar.controller;

import com.example.AuctionBazaar.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class AuctionNotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendUpcomingAuction")
    public String sendUpcomingAuctionNotification(
            @RequestParam String email,
            @RequestParam String auctionTitle,
            @RequestParam String auctionTime) {
        String subject = "Upcoming Auction Notification";
        String body = String.format("Hello,\n\nThe auction '%s' is scheduled for %s.\n\nBest regards,\nAuctionBazaar Team",
                auctionTitle, auctionTime);
        emailService.sendEmail(email, subject, body);
        return "Upcoming auction notification sent successfully to " + email;
    }

    @PostMapping("/sendWinningBid")
    public String sendWinningBidNotification(
            @RequestParam String email,
            @RequestParam String auctionTitle,
            @RequestParam String winningAmount) {
        String subject = "Congratulations! You Won the Auction";
        String body = String.format("Hello,\n\nCongratulations! You won the auction '%s' with a bid amount of %s.\n\nBest regards,\nAuctionBazaar Team",
                auctionTitle, winningAmount);
        emailService.sendEmail(email, subject, body);
        return "Winning bid notification sent successfully to " + email;
    }
}
