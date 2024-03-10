package com.demo.niq.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_info")
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;
    private String category;
    private String brand;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productInfo", fetch = FetchType.LAZY)
    private Set<Relevancy> relevancyInfos = new HashSet<>();

    public Product() {
    }

    public Product(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Set<Relevancy> getRelevancyInfos() {
        return relevancyInfos;
    }

    public void setRelevancyInfos(Set<Relevancy> relevancyInfos) {
        this.relevancyInfos = relevancyInfos;
    }
}
