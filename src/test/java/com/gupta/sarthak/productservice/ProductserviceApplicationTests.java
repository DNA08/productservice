package com.gupta.sarthak.productservice;

import com.gupta.sarthak.productservice.models.Category;
import com.gupta.sarthak.productservice.models.Product;
import com.gupta.sarthak.productservice.repositories.CategoryRepository;
import com.gupta.sarthak.productservice.repositories.ProductRepository;
import com.gupta.sarthak.productservice.repositories.projections.ProductWithTitleAndPrice;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.smartcardio.CardTerminal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductserviceApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void testQuery(){
		ProductWithTitleAndPrice product = this.productRepository.getProductWithTitleAndPrice(2l);
		System.out.println("Product Title: " + product.getTitle());
		System.out.println("Product Price: " + product.getPrice());
	}

	@Transactional
	@Test
	void testTransactional(){
		Optional<Category> category = this.categoryRepository.findById(1l);
		List<Product> products = category.get().getProducts();
		for(Product product : products){
			System.out.println("Product Title: " + product.getTitle());
			System.out.println("Product Price: " + product.getPrice());
		}
	}

}
