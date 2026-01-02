package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")


public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/getAll")
    public List<Map<String,Object>> getProducts(){
        return service.getProducts();
    }

    @PostMapping("/insert-one")
    public String addProduct(@RequestBody Product p){

        return service.addProduct(p);
    }

}