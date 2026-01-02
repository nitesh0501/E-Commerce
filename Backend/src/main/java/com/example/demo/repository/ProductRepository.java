package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.queryForList(sql);
    }

    public int saveProduct(Product product) {
        String sql = "INSERT INTO products(name,description, price, quantity,category,image) " +
                "VALUES(?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory(),
                product.getImage()
        );
    }
}
