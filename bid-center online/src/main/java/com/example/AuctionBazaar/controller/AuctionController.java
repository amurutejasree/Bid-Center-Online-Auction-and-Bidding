package com.example.AuctionBazaar.controller;

import com.example.AuctionBazaar.Model.Auction;
import com.example.AuctionBazaar.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

    @PostMapping("/create")
    public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
        return new ResponseEntity<>(auctionService.createAuction(auction), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Auction> updateAuction(@PathVariable Long id, @RequestBody Auction updatedAuction) {
        return auctionService.updateAuction(id, updatedAuction)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuction(@PathVariable Long id) {
        auctionService.deleteAuction(id);
        return ResponseEntity.noContent().build();
    }
}

