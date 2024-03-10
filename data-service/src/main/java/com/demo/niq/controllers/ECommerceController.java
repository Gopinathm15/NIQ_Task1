package com.demo.niq.controllers;

import com.demo.niq.domain.Product;
import com.demo.niq.response.AppBaseResponse;
import com.demo.niq.services.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/external/ecommerce-service")
public class ECommerceController {

    @Autowired
    private ECommerceService eCommerceService;

    @RequestMapping(path = "/get-product-info", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getProductInfo(@RequestParam(name = "shopperId") String shopperId, @RequestParam(name = "category", required = false) String category, @RequestParam(name = "brand", required = false) String brand, @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit) {
        List productsByShopper = eCommerceService.getProductsByShopper(shopperId, category, brand, limit);
        return ResponseEntity.ok(new AppBaseResponse<>(productsByShopper));
    }
}
