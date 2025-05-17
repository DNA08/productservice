package com.gupta.sarthak.productservice.models;


import jakarta.persistence.Entity;

@Entity
public class Category extends BaseModel{

    private String value;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
