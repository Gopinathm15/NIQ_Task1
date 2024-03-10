package com.demo.niq.services.impl;

import com.demo.niq.domain.Product;
import com.demo.niq.repositories.ProductRepository;
import com.demo.niq.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveOrUpdateProductDetails(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductDetails(Product product) {
        return null;
    }

    @Override
    public Product deleteProductDetails(Product product) {
        return null;
    }
}
