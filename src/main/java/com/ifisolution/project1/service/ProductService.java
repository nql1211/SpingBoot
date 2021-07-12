package com.ifisolution.project1.service;

import com.ifisolution.project1.entity.Products;
import com.ifisolution.project1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Products products) {
        productRepository.save(products);
    }

    public void deleteProduct(Long id){
        productRepository.findById(id);
        boolean exist = productRepository.existsById(id);
        if (!exist){
            throw new IllegalStateException("Product with id:" + id + " dose not exist");
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(Long productID, String productName, Double price,  String category){
        Products products = productRepository.findById(productID).orElseThrow(
                () -> new IllegalStateException("Product with id: " + productID + " dose not exist")
        );

        if (productName != null && productName.length() > 0 ){
            products.setProductName(productName);
        }
        products.setPrice(price);
    }
}
