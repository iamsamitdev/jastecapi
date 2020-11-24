package com.itgenius.jastecapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itgenius.jastecapi.exception.ResourceNotFoundException;
import com.itgenius.jastecapi.model.Product;
import com.itgenius.jastecapi.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
     // Read All products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    // Read Product By ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") int productId)
        throws ResourceNotFoundException {
        Product user = productRepository.findById(productId)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(user);
    }
    
    // Add new Product
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }
    
    
    // Update Product
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") int productId,
         @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setProductName(productDetails.getProductName());
        product.setProductBarcode(productDetails.getProductBarcode());
        product.setProductDetail(productDetails.getProductDetail());
        product.setProductQty(productDetails.getProductQty());
        product.setProductPrice(productDetails.getProductPrice());
        product.setProductDate(productDetails.getProductDate());
        product.setProductImage(productDetails.getProductImage());
        product.setProductCategory(productDetails.getProductCategory());
        product.setProductStatus(productDetails.getProductStatus());
        
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
        
    }
    
    // Delete Product
    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") int productId)
         throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
       .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}
