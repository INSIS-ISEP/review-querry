package com.isep.reviewsq.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isep.reviewsq.model.Product;
import com.isep.reviewsq.model.Review;
import com.isep.reviewsq.model.User;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.approvalStatus='pending'")
    Optional<List<Review>> findPendingReviews();

    @Query("SELECT r FROM Review r WHERE r.product=:product AND r.approvalStatus=:status ORDER BY r.publishingDate DESC")
    Optional<List<Review>> findByProductIdStatus(Product product, String status);

    // @Query("SELECT r FROM Review r WHERE r.user=:user ORDER BY r.publishingDate DESC")
    // Optional<List<Review>> findByUserId(User user);
}
