package com.ifisolution.project1.controller;

import com.ifisolution.project1.entity.Products;
import com.ifisolution.project1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("")
    public void addProduct(@RequestBody Products products){
        productService.addProduct(products);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }


    @PutMapping("/{id}")
    public void updateProduct(
            @PathVariable("id") Long productId,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String category){
        productService.updateProduct(productId, productName, price, category);
    }

}
