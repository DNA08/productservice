package com.gupta.sarthak.productservice.services;

import com.gupta.sarthak.productservice.dtos.FakeStoreProductDto;
import com.gupta.sarthak.productservice.exceptions.ProductNotFoundException;
import com.gupta.sarthak.productservice.models.Category;
import com.gupta.sarthak.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private final RestTemplate restTemplate;

    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
            FakeStoreProductDto fakeStoreProductDto = this.restTemplate.getForObject(
                    "https://fakestoreapi.com/products/" + id,
                    FakeStoreProductDto.class);
            if(fakeStoreProductDto == null) {
                throw new ProductNotFoundException(id.toString());
            }
            return fromFakeStoreProductDto(fakeStoreProductDto);
    }



    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        FakeStoreProductDto[] fakeStoreProductDtos = this.restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
//        if (fakeStoreProductDtos == null) {
//            return List.of();
//        }
//        return List.of(fakeStoreProductDtos).stream()
//                .map(this::fromFakeStoreProductDto)
//                .toList();
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
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
