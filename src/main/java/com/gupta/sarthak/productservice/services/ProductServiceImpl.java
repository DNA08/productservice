package com.gupta.sarthak.productservice.services;

import com.gupta.sarthak.productservice.dtos.FakeStoreProductDto;
import com.gupta.sarthak.productservice.models.Category;
import com.gupta.sarthak.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownContentTypeException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final RestTemplate restTemplate;

    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        try {
            FakeStoreProductDto fakeStoreProductDto = this.restTemplate.getForObject(
                    "https://fakestoreapi.com/products/" + id,
                    FakeStoreProductDto.class);
            return fromFakeStoreProductDto(fakeStoreProductDto);
        } catch (UnknownContentTypeException e) {
            // Log the error and handle the case where the response is not JSON
            System.err.println("Error fetching product: " + e.getMessage());
            return null;
        }
    }



    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = this.restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        if (fakeStoreProductDtos == null) {
            return List.of();
        }
        return List.of(fakeStoreProductDtos).stream()
                .map(this::fromFakeStoreProductDto)
                .toList();
    }

    @Override
    public void createProduct(Product product) {

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

    private Product fromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        if(fakeStoreProductDto == null) {
            return null;
        }
        Category category = new Category();
        category.setValue(fakeStoreProductDto.getCategory());
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice().toString());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setCategory(category);
        return product;
    }
}
