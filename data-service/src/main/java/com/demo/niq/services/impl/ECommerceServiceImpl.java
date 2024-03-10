package com.demo.niq.services.impl;

import com.demo.niq.domain.Shopper;
import com.demo.niq.exceptions.BadRequestHttpException;
import com.demo.niq.repositories.ECommerceRepository;
import com.demo.niq.repositories.ProductRepository;
import com.demo.niq.repositories.ShopperRepository;
import com.demo.niq.services.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ECommerceServiceImpl implements ECommerceService {

    @Autowired
    private ShopperRepository shopperRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ECommerceRepository eCommerceRepository;

    @Override
    //@Cacheable(value = "products", key = "#productId + '-' + #category + '-' #brand")
    public List getProductsByShopper(String shopperId, String category, String brand, Integer limit) {
        Optional<Shopper> shopperInfoDB = shopperRepository.findById(shopperId);
        if (shopperInfoDB.isEmpty()) {
            throw new BadRequestHttpException("4001");
        }
        return eCommerceRepository.findByShopperProductWithFilters(shopperId, category, brand, limit);
    }
}
