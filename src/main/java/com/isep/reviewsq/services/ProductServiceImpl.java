package com.isep.reviewsq.services;

import com.isep.reviewsq.model.Product;
import com.isep.reviewsq.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Optional<Product> findBySku(String sku) {
        final Optional<Product> product = repository.findBySku(sku);

        if( product.isEmpty() )
            return Optional.empty();
        else
            return Optional.of( product.get());
    }


}
