package com.isep.reviewsq.services;

import java.util.List;

import com.isep.reviewsq.model.*;

public interface ReviewService {

    Iterable<Review> getAll();

    // List<ReviewDTO> findReviewsByUser(Long userID);

    List<ReviewDTO> getReviewsOfProduct(String sku, String status);

    List<ReviewDTO> findPendingReview();


}
