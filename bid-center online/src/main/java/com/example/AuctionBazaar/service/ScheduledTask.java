package com.example.AuctionBazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?") // Every day at 9 AM
    public void sendDailyUpcomingAuctionEmails() {
        // Fetch upcoming auctions and users from the database
        // Example logic:
        String email = "akashu38143@gmail.com";
        String auctionTitle = "Daily Vintage Art Auction";
        String auctionTime = "2024-12-01 10:00 AM";
        emailService.sendEmail(email,
                "Daily Auction Reminder",
                String.format("Reminder: Auction '%s' is happening at %s.", auctionTitle, auctionTime));
    }
}
