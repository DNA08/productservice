package com.gupta.sarthak.productservice;

import com.gupta.sarthak.productservice.repositories.ProductRepository;
import com.gupta.sarthak.productservice.repositories.projections.ProductWithTitleAndPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductserviceApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void testQuery(){
		ProductWithTitleAndPrice product = this.productRepository.getProductWithTitleAndPrice(2l);
		System.out.println("Product Title: " + product.getTitle());
		System.out.println("Product Price: " + product.getPrice());
	}

}
