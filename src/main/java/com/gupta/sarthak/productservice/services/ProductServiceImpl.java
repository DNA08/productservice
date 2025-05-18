package com.gupta.sarthak.productservice.services;

import com.gupta.sarthak.productservice.exceptions.ProductNotFoundException;
import com.gupta.sarthak.productservice.models.Category;
import com.gupta.sarthak.productservice.models.Product;
import com.gupta.sarthak.productservice.repositories.CategoryRepository;
import com.gupta.sarthak.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = this.productRepository.findById(id);
        return optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product not found for the given id: " + id));
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return this.productRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by("price").ascending())
        );
    }

    @Override
    public Product createProduct(Product product) {
//        if(product.getCategory() != null){
//            if(product.getCategory().getId() == null){
//                Category category = product.getCategory();
//                String value = category.getValue();
//                Optional<Category> optionalCategory = this.categoryRepository.findByValue(value);
//                if(optionalCategory.isEmpty()){
//                    category = this.categoryRepository.save(category);
//                    product.setCategory(category);
//                }else{
//                    product.setCategory(optionalCategory.get());
//                }
//            }
//        }else{
//            throw new RuntimeException("Category id " + product.getCategory().getId() + " is already exists");
//        }
        return this.productRepository.save(product);
    }

    @Override
    public void updateProduct(String id, Product updateProduct) {

    }

    @Override
    public void deleteProduct(String id) {

    }

    @Override
    public void replaceProduct(String id, Product replaceProduct) {

    }
}
