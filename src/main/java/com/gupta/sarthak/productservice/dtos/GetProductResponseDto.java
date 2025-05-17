package com.gupta.sarthak.productservice.dtos;

import com.gupta.sarthak.productservice.models.Product;

public class GetProductResponseDto {

    private String title;
    private String price;
    private String description;
    private String image;
    private String category;

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static GetProductResponseDto fromProduct(Product createdProduct) {
        GetProductResponseDto getProductResponseDto = new GetProductResponseDto();
        getProductResponseDto.setTitle(createdProduct.getTitle());
        getProductResponseDto.setPrice(createdProduct.getPrice());
        getProductResponseDto.setDescription(createdProduct.getDescription());
        getProductResponseDto.setImage(createdProduct.getImage());
        getProductResponseDto.setCategory(createdProduct.getCategory().getValue());
        return getProductResponseDto;
    }
}
