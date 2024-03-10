package com.demo.niq.repositories;

import com.demo.niq.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

   /* @Query("FROM Product p JOIN Relevancy r ON p.productId = r.productInfo.productId WHERE r.shopperInfo.shopperId=:shopperId AND (:category IS NULL OR p.category = :category) AND (:brand IS NULL OR p.brand = :brand)")
    Page<Product> findByShopperProductWithFilters(@Param("shopperId") String shopperId,
                                                  @Param("category") String category,
                                                  @Param("brand") String brand,
                                                  Pageable pageable);*/

    @Query(value = "SELECT * FROM product_info p JOIN relevancy_info r ON p.product_id = r.product_id WHERE r.shopper_id=:shopperId AND (:category IS NULL OR p.category = :category) AND (:brand IS NULL OR p.brand = :brand)", nativeQuery = true)
    Page<Object[]> findByShopperProductWithFilters(@Param("shopperId") String shopperId,
                                                  @Param("category") String category,
                                                  @Param("brand") String brand,
                                                  Pageable pageable);

}
