package com.example.AuctionBazaar.repository;

import com.example.AuctionBazaar.Model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {}
