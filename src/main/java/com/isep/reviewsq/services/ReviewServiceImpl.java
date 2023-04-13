package com.isep.reviewsq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isep.reviewsq.model.*;
import com.isep.reviewsq.repositories.ProductRepository;
import com.isep.reviewsq.repositories.ReviewRepository;
import com.isep.reviewsq.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository repository;

    @Autowired
    ProductRepository pRepository;

    @Autowired
    UserRepository uRepository;

    @Override
    public Iterable<Review> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ReviewDTO> getReviewsOfProduct(String sku, String status) {

        Optional<Product> product = pRepository.findBySku(sku);
        if( product.isEmpty() ) return null;

        Optional<List<Review>> r = repository.findByProductIdStatus(product.get(), status);

        if (r.isEmpty()) return null;
        
        List<ReviewDTO> rDTO = r.get().stream().map(ReviewMapper::toDto).collect(Collectors.toList());
        return rDTO;
    }


    @Override
    public List<ReviewDTO> findPendingReview(){

        Optional<List<Review>> r = repository.findPendingReviews();

        if(r.isEmpty()){
            return null;
        }
        
        List<ReviewDTO> rDTO = r.get().stream().map(ReviewMapper::toDto).collect(Collectors.toList());
        return rDTO;
       
    }

    // @Override
    // public List<ReviewDTO> findReviewsByUser(Long userID) {
        
    //     Optional<User> user = uRepository.findById(userID);
    //     if( user.isEmpty() ) return null;

    //     Optional<List<Review>> r = repository.findByUserId(user.get());

    //     if (r.isEmpty()) return null;

    //     List<ReviewDTO> rDTO = r.get().stream().map(ReviewMapper::toDto).collect(Collectors.toList());
    //     return rDTO;
    // }
} 