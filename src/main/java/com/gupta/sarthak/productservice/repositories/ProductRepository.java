package com.gupta.sarthak.productservice.repositories;

import com.gupta.sarthak.productservice.models.Product;
import com.gupta.sarthak.productservice.repositories.projections.ProductWithTitleAndPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long productId);

    @Override
    Page<Product> findAll(Pageable pageable);

    @Query("select p.title as title, p.price as price from Product p where p.id = :productId")
    ProductWithTitleAndPrice getProductWithTitleAndPrice(@Param("productId") Long productId);

}
