package com.demo.niq.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class ProductRequest {
    private String productId;
    private String category;
    private String brand;
    private BigDecimal relevancyScore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductRequest that)) return false;
        return Objects.equals(productId, that.productId) && Objects.equals(category, that.category) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, category, brand);
    }
}
