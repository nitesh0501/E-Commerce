package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repo;

    public List<Map<String,Object>> getProducts()
    {
        return repo.getAllProducts();
    }

    public String addProduct(Product p) {
        int rows = repo.saveProduct(p);
        return rows > 0 ? "Product Added" : "Failed";
    }
}