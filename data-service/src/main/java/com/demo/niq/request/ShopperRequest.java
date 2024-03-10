package com.demo.niq.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ShopperRequest {
    private String shopperId;
    private ProductRequest product;
    private int limit = 10;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopperRequest that)) return false;
        return shopperId.equals(that.shopperId) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopperId, product);
    }
}
