package com.example.AuctionBazaar.repository;

import com.example.AuctionBazaar.Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByResetToken(String token);
    Optional<User> findById(int id);
}
