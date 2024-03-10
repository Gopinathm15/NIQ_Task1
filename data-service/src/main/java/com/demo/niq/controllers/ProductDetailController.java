package com.demo.niq.controllers;

import com.demo.niq.domain.Product;
import com.demo.niq.response.AppBaseResponse;
import com.demo.niq.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductDetailController {

    @Autowired
    //@Qualifier("productServiceImpl")
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addProduct(@RequestBody Product product){
        productService.saveOrUpdateProductDetails(product);
        return ResponseEntity.ok(new AppBaseResponse<>());
    }

}

