package com.gupta.sarthak.productservice.controllers;

import com.gupta.sarthak.productservice.dtos.GetProductResponseDto;
import com.gupta.sarthak.productservice.dtos.ProductNotFoundExceptionDto;
import com.gupta.sarthak.productservice.exceptions.ProductNotFoundException;
import com.gupta.sarthak.productservice.models.Product;
import com.gupta.sarthak.productservice.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundExceptionDto(ProductNotFoundException exception) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setMessage("Product not found for the given "+exception.getId()+" from Controller!!!");
        productNotFoundExceptionDto.setResolution("Check the id and try again.");
        return new ResponseEntity<>(
                productNotFoundExceptionDto,
                HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/create")
//    public GetProductResponseDto createProduct(String title, String price, String category, String description, String image) {
//        return new GetProductResponseDto(title, price, category, description, image);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteProductById(String id) {
//        // Logic to delete the product by ID
//    }

//    @PutMapping("/{id}")
//    public GetProductResponseDto updateProductById(String id, String title, String price, String category, String description, String image) {
//        return new GetProductResponseDto(title, price, category, description, image);
//    }
//
//    @PatchMapping("/{id}")
//    public GetProductResponseDto patchProductById(String id, String title, String price, String category, String description, String image) {
//        return new GetProductResponseDto(title, price, category, description, image);
//    }
}
