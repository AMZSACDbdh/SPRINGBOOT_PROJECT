package com.example.e_commerce1.controller;

import com.example.e_commerce1.dto.ProductRequestDTO;
import com.example.e_commerce1.model.Product;
import com.example.e_commerce1.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // Added to track product operations
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductRequestDTO requestDto) {
        
        Product newProduct = new Product();
        newProduct.setName(requestDto.getName());
        newProduct.setDescription(requestDto.getDescription());
        newProduct.setPrice(requestDto.getPrice());
        newProduct.setStock(requestDto.getStock());

        return productService.addProduct(newProduct);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
}
