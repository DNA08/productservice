package com.gupta.sarthak.productservice.services;
import com.gupta.sarthak.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void createProduct(Product product);

    void updateProduct(String id, Product updateProduct);

    void deleteProduct(String id);

    void replaceProduct(String id, Product replaceProduct);
}
