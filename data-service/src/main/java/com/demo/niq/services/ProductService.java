package com.demo.niq.services;

import com.demo.niq.domain.Product;

public interface ProductService {
    void saveOrUpdateProductDetails(Product product);
    Product getProductDetails(Product product);
    Product deleteProductDetails(Product product);
}
