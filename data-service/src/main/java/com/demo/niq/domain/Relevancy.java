package com.demo.niq.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "relevancy_info")
public class Relevancy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal score;
    @ManyToOne
    @JoinColumn(name = "shopper_id", nullable = false)
    private Shopper shopperInfo;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productInfo;

    public Relevancy() {
    }

    public Relevancy(BigDecimal score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Shopper getShopperInfo() {
        return shopperInfo;
    }

    public void setShopperInfo(Shopper shopperInfo) {
        this.shopperInfo = shopperInfo;
    }

    public Product getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(Product productInfo) {
        this.productInfo = productInfo;
    }


}
