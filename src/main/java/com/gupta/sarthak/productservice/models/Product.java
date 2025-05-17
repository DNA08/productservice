package com.gupta.sarthak.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Product extends BaseModel {

    private String title;
    private String price;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Category category;
    private String description;
    private String image;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

}
