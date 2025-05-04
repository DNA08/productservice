package com.gupta.sarthak.productservice.controlleradvice;

import com.gupta.sarthak.productservice.dtos.ProductNotFoundExceptionDto;
import com.gupta.sarthak.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundExceptionDto(ProductNotFoundException productNotFoundException) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setMessage("Product not found for the given id. "+ productNotFoundException.getId());
        productNotFoundExceptionDto.setResolution("Check the id and try again.");
        return new ResponseEntity<>(
                productNotFoundExceptionDto,
                HttpStatus.NOT_FOUND);
    }
}
