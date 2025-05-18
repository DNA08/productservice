package com.gupta.sarthak.productservice.services;
import com.gupta.sarthak.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product createProduct(Product product);

    void updateProduct(String id, Product updateProduct);

    void deleteProduct(String id);

    void replaceProduct(String id, Product replaceProduct);
}
