package com.gupta.sarthak.productservice.repositories;

import com.gupta.sarthak.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Optional<Category> findById(Long categoryId);

    Category save(Category category);

    Optional<Category> findByValue(String value);
}
