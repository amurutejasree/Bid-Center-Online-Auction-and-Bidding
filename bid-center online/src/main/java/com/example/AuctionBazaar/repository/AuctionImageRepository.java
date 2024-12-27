package com.example.AuctionBazaar.repository;

import com.example.AuctionBazaar.Model.AuctionImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionImageRepository extends JpaRepository<AuctionImage, Long> {}
