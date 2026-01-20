package com.example.e_commerce1.service;

import com.example.e_commerce1.exception.ProductNotFoundException;
import com.example.e_commerce1.model.Product;
import com.example.e_commerce1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found"));
    }
}
