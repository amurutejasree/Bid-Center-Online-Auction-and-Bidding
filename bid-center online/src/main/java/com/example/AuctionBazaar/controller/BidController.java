package com.example.AuctionBazaar.controller;

import com.example.AuctionBazaar.DTO.BidRequest;
import com.example.AuctionBazaar.Model.Bid;
import com.example.AuctionBazaar.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping("/placeBid")
    public ResponseEntity<String> placeBid(@RequestBody BidRequest bidRequest) {
        Long auctionId = bidRequest.getAuctionId();
        Long userId = bidRequest.getUserId();
        BigDecimal bidAmount = bidRequest.getBidAmount();

        try {
            bidService.placeBid(auctionId, userId, bidAmount);
            return new ResponseEntity<>("Bid placed successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/viewBids/{auctionId}")
    public ResponseEntity<List<Bid>> viewBids(@PathVariable Long auctionId) {
        List<Bid> bids = bidService.getBidsByAuctionId(auctionId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }
}