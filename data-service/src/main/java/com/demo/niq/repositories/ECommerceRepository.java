package com.demo.niq.repositories;

import com.demo.niq.domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ECommerceRepository {

    private final JdbcTemplate jdbcTemplate;

    public ECommerceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findByShopperProductWithFilters(String shopperId, String category, String brand, Integer limit) {
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM product_info p JOIN relevancy_info r ON p.product_id = r.product_id WHERE r.shopper_id=? ");
        List<Object> paramValue = new ArrayList<>();
        paramValue.add(shopperId);
        if (category != null) {
            sqlQuery.append(" AND p.category = ?");
            paramValue.add(category);
        }
        if (brand != null) {
            sqlQuery.append(" AND p.brand = ?");
            paramValue.add(brand);
        }
        sqlQuery.append(" LIMIT ?");
        paramValue.add(limit);
        return jdbcTemplate.query(sqlQuery.toString(), paramValue.toArray(), new ProductRowMapper());
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductId(resultSet.getString("product_id"));
            product.setCategory(resultSet.getString("category"));
            product.setBrand(resultSet.getString("brand"));
            return product;
        }
    }
}
