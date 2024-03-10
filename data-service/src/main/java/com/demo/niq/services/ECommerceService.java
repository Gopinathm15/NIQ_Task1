package com.demo.niq.services;

import com.demo.niq.domain.Product;

import java.util.List;

public interface ECommerceService {
    List<Product> getProductsByShopper(String shopperId, String category, String brand, Integer limit);
}
