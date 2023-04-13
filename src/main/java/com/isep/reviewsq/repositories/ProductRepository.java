package com.isep.reviewsq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.isep.reviewsq.model.Product;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
}

