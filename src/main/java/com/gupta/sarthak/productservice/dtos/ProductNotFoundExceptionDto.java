package com.gupta.sarthak.productservice.dtos;

public class ProductNotFoundExceptionDto {
    private String message;
    private String resolution;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getMessage() {
        return message;
    }

    public String getResolution() {
        return resolution;
    }
}
