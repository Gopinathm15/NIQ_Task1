package com.demo.niq.services.impl;

import com.demo.niq.domain.Product;
import com.demo.niq.domain.Relevancy;
import com.demo.niq.domain.Shopper;
import com.demo.niq.exceptions.BadRequestHttpException;
import com.demo.niq.repositories.ProductRepository;
import com.demo.niq.repositories.RelevancyRepository;
import com.demo.niq.repositories.ShopperRepository;
import com.demo.niq.request.PersonalizedProductRequest;
import com.demo.niq.request.ProductRequest;
import com.demo.niq.services.DataTeamInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Optional;

@Service
public class DataTeamInterfaceImpl implements DataTeamInterface {

    @Autowired
    private RelevancyRepository relevancyRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShopperRepository shopperRepository;

    @Override
    @Transactional
    public void storeData(PersonalizedProductRequest personalizedProductRequest) {
        Optional<Shopper> shopperInfoDB = shopperRepository.findById(personalizedProductRequest.getShopperId());
        if (shopperInfoDB.isEmpty()) {
            shopperInfoDB =  Optional.of(new Shopper(personalizedProductRequest.getShopperId()));
            shopperRepository.saveAndFlush(shopperInfoDB.get());
        }

        List<ProductRequest> productList = personalizedProductRequest.getProductList();
        Optional<Shopper> finalShopperInfoDB = shopperInfoDB;
        productList.forEach(personalizedProduct -> {
            Optional<Product> productInfoDB = productRepository.findById(personalizedProduct.getProductId());
            if (productInfoDB.isEmpty()) {
                throw new BadRequestHttpException("4000");
            }
            Relevancy relevancyInfo = new Relevancy(personalizedProduct.getRelevancyScore());
            relevancyInfo.setProductInfo(productInfoDB.get());
            relevancyInfo.setShopperInfo(finalShopperInfoDB.get());
            relevancyRepository.save(relevancyInfo);
        });
    }
}
