package com.gupta.sarthak.productservice.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category extends BaseModel{

    @Column(unique = true)
    private String value;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
