package com.josh.SpringEcom.controller;

import com.josh.SpringEcom.model.Product;
import com.josh.SpringEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId){
        Product product = productService.getProductById(productId);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping( value = "/products", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(@RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile imageFile)  {

        Product savedProduct = null;
        try {
            savedProduct = productService.addorUpdateProduct(product,imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/products/{productId}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable("productId") int productId){
        Product product = productService.getProductById(productId);
        if(product != null){
            return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable int productId,
                                                @RequestPart Product product,@RequestPart("imageFile") MultipartFile imageFile){
        Product updatedProduct= null;
        try {
            updatedProduct = productService.addorUpdateProduct(product,imageFile);
            return new ResponseEntity<>("updated successfully!!", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId,
                                                @RequestPart Product product,@RequestPart("imageFile") MultipartFile imageFile){
        String deleteProduct = productService.deleteProduct(productId);
        if(deleteProduct != null){
        return new ResponseEntity<>("delete successfully!!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
