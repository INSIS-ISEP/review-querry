package com.isep.reviewsq.services;

import java.util.Optional;

import com.isep.reviewsq.model.Product;


public interface ProductService {

    Optional<Product> findBySku(final String sku);



}
