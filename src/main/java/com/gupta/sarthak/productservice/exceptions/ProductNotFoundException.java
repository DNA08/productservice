package com.gupta.sarthak.productservice.exceptions;


public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String id;

    public ProductNotFoundException(String id) {
        super("Product not found with id: " + id);
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
