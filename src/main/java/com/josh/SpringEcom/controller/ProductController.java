package com.josh.SpringEcom.controller;

import com.josh.SpringEcom.model.Product;
import com.josh.SpringEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId){
        Product product = productService.getProductById(productId);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) throws IOException {

        Product savedProduct = productService.createProduct(product,imageFile);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}
